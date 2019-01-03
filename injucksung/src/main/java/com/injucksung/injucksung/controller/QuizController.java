package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.dto.BookContentSelectForm;
import com.injucksung.injucksung.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuestionService questionService;

    //문제 리스트 가져오기
    @GetMapping
    public ModelAndView getQuestionList(@ModelAttribute BookContentSelectForm bookContentSelectForm,
                                        ModelAndView modelAndView) {
        // TODO: checkbox를 하나도 선택 안한 경우의 예외처리
        // TODO: for문 말고 JPA에서 해결하도록 하자 (임시용)
        List<Question> questions = new ArrayList<>();
        for (Long bookContentId : bookContentSelectForm.getBookContentId()) {
            List<Question> content = questionService.getQuestionList(bookContentId);
            if (content != null) {
                questions.addAll(content);
            }
        }
        modelAndView.addObject("questions", questions);

        if (bookContentSelectForm.getAction().equals("문제풀기")) modelAndView.setViewName("/users/quiz/grade");
        else modelAndView.setViewName("/users/quiz/solve");
        return modelAndView;
    }

}
