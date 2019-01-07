package com.injucksung.injucksung.controller.user;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.domain.Result;
import com.injucksung.injucksung.dto.BookContentSelectForm;
import com.injucksung.injucksung.security.CustomUserDetails;
import com.injucksung.injucksung.service.QuestionService;
import com.injucksung.injucksung.service.QuizRecordService;
import com.injucksung.injucksung.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuestionService questionService;
    private final QuizRecordService quizRecordService;
    private final ResultService resultService;

    //문제 리스트 가져오기
    @GetMapping
    public ModelAndView getQuestionList(@ModelAttribute BookContentSelectForm bookContentSelectForm,
                                        ModelAndView modelAndView) {
        // TODO: checkbox를 하나도 선택 안한 경우의 예외처리
        // TODO: for문 말고 join fetch로 해결하도록 하자 (임시용)
        List<Question> questions = new ArrayList<>();
        for (Long bookContentId : bookContentSelectForm.getBookContentId()) {
            List<Question> content = questionService.getQuestionList(bookContentId);
            if (content != null) {
                questions.addAll(content);
            }
        }
        modelAndView.addObject("questions", questions);
        if (bookContentSelectForm.getAction().equals("문제풀기")) modelAndView.setViewName("/users/quiz/solve");
        else modelAndView.setViewName("/users/quiz/grade");
        return modelAndView;
    }

    //퀴즈 종료 후 결과
    @PostMapping
    public String submitQuiz(@RequestParam Map<String, String> selectedChoices, Model model) {
        selectedChoices.remove("_csrf");
        // TODO: selectedChoices의 타입을 Map<Long, Integer>로 바뀌게 하는걸 컨트롤러에서 하는게 좋은거 같다

        //세션에 저장된 스프링 시큐리티 정보로 CumtomUserDetails 가져오기
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //QuizRecord 추가
        QuizRecord quizRecord = quizRecordService.addQuizRecordService(selectedChoices, userDetails);

        //Record 추가
        List<Result> results = resultService.addResult(selectedChoices, quizRecord);

        //사용자에게 Record 보여주기
        model.addAttribute("quizRecord", quizRecord);
        model.addAttribute("results", results);
        return "/users/quiz/result";
    }

}
