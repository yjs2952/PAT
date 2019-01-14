package com.injucksung.injucksung.controller.admin;

import com.injucksung.injucksung.dto.QuestionForm;
import com.injucksung.injucksung.service.BookContentService;
import com.injucksung.injucksung.service.BookService;
import com.injucksung.injucksung.service.QuestionCategoryService;
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
    private final QuestionCategoryService questionCategoryService;
    private final BookService bookService;
    private final BookContentService bookContentService;

    //문제 목록 가져오기
    @GetMapping
    public String getQuestionList(@RequestParam(value = "start", defaultValue = "0") int start, Model model) {
        model.addAttribute("questionPage", questionService.getQuestionList(start));
        return "admin/questions/list";
    }

    //문제 등록하기
    @GetMapping("/edit")
    public String addQuestion(Model model) {
        model.addAttribute("questionCategoryPage", questionCategoryService.getQuestionCategoryList(0));
        model.addAttribute("bookPage", bookService.getBookList(0));
        model.addAttribute("bookContentList", bookContentService.getBookContentList(1L));
        return "admin/questions/edit";
    }

    @PostMapping
    public String addQuestion(@ModelAttribute QuestionForm questionForm) {
        questionService.addQuestion(questionForm);
        return "redirect:/admin/questions";
    }
}