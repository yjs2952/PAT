package com.injucksung.injucksung.controller.user;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.domain.Result;
import com.injucksung.injucksung.dto.SelectedBookContentForQuizForm;
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

import java.util.HashMap;
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
    public ModelAndView getQuestionList(@ModelAttribute SelectedBookContentForQuizForm selectedBookContentForQuizForm,
                                        ModelAndView modelAndView) {
        // TODO: checkbox를 하나도 선택 안한 경우의 예외처리

        List<Question> questions = questionService.getQuestionList(selectedBookContentForQuizForm);

        modelAndView.addObject("questions", questions);
        modelAndView.addObject("bookContentCount", selectedBookContentForQuizForm.getBookContentIds().length);
        if (selectedBookContentForQuizForm.getAction().equals("문제풀기")) modelAndView.setViewName("/users/quiz/solve");
        else modelAndView.setViewName("/users/quiz/grade");
        return modelAndView;
    }

    //퀴즈 종료 후 결과
    @PostMapping
    public String submitQuiz(@RequestParam Map<String, String> selectedChoices, Model model) {
        //Map 으로 넘어온 모든 파라미터 수정 (불필요한 csrf 제거, 타입을 String, String 에서 Long, Integer 로 변경)
        selectedChoices.remove("_csrf");
        int bookContentCount =  Integer.parseInt(selectedChoices.get("bookContentCount"));
        selectedChoices.remove("bookContentCount");

        Map<Long, Integer> typeCorrectedSelectedChoices = new HashMap<>();
        for (Map.Entry<String, String> selectedChoice : selectedChoices.entrySet()) {
            typeCorrectedSelectedChoices.put(Long.parseLong(selectedChoice.getKey()), Integer.parseInt(selectedChoice.getValue()));
        }

        //세션에 저장된 스프링 시큐리티 정보로 CustomUserDetails 가져오기
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //QuizRecord 추가
        QuizRecord quizRecord = quizRecordService.addQuizRecordService(typeCorrectedSelectedChoices, userDetails, bookContentCount);

        //Result 추가
        List<Result> results = resultService.addResult(typeCorrectedSelectedChoices, quizRecord);

        //사용자에게 result 보여주기
        model.addAttribute("quizRecord", quizRecord);
        model.addAttribute("results", results);
        return "/users/quiz/result";
    }

}
