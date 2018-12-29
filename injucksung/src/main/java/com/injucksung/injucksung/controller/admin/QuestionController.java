package com.injucksung.injucksung.controller.admin;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/questions")
public class QuestionController {
    private final QuestionService questionService;

    //문제 목록 가져오기
    @GetMapping
    public String questionList(@RequestParam(value = "start", defaultValue = "0") int start, Model model) {
        model.addAttribute("questionPage", questionService.getQuestionList(start));
        return "admin/questions/list";
    }

    //문제 등록하기
    @GetMapping("/edit")
    public String addQuestion() {
        return "admin/questions/edit";
    }

    @PostMapping("/edit")
    public String addQuestion(@ModelAttribute Question question) {
        return "admin/questions/" + question.getId();
    }
}
