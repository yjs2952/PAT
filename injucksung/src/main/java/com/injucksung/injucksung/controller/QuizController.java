package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
    private final QuestionService questionService;

    //문제 리스트 가져오기
    @GetMapping String getQuestionList() {

    }

}
