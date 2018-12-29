package com.injucksung.injucksung.controller.admin;

import com.injucksung.injucksung.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/questions")
public class QuestionController {
    private final QuestionService questionService;

    //문제 목록 가져오기
    @GetMapping
    public String questionList(@RequestParam(value = "start", defaultValue = "0") int start, Model model) {
        model.addAttribute("questionPage",questionService.getQuestionList(start));
        return "admin/questions/list";
    }
}
