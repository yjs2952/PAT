package com.injucksung.injucksung.controller.user;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.domain.Result;
import com.injucksung.injucksung.dto.SelectedBookContentForQuizForm;
import com.injucksung.injucksung.dto.SubmittedQuizInfoDto;
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
        if (selectedBookContentForQuizForm.getAction().equals("문제풀기")) modelAndView.setViewName("/users/quiz/solving");
        else modelAndView.setViewName("/users/quiz/grading");
        return modelAndView;
    }

    //퀴즈 종료 후 결과
    @PostMapping
    public String submitQuiz(@RequestParam Map<String, String> submittedQuizInfo, Model model) {
        SubmittedQuizInfoDto submittedQuizInfoDto = new SubmittedQuizInfoDto(submittedQuizInfo);

        //세션에 저장된 스프링 시큐리티 정보로 CustomUserDetails 가져오기
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        QuizRecord quizRecord = quizRecordService.addQuizRecordService(submittedQuizInfoDto, userDetails);
        List<Result> results = resultService.addResult(submittedQuizInfoDto, quizRecord);

        model.addAttribute("quizRecord", quizRecord);
        model.addAttribute("results", results);
        return "/users/quiz/result";
    }

}
