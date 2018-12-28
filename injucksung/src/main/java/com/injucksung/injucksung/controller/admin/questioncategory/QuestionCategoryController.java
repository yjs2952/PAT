package com.injucksung.injucksung.controller.admin.questioncategory;

import com.injucksung.injucksung.domain.QuestionCategory;
import com.injucksung.injucksung.service.QuestionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/question-categories")
public class QuestionCategoryController {
    private final QuestionCategoryService questionCategoryService;

    //문제 카테고리 리스트 가져오기
    @GetMapping
    public String questionCateogryList(@RequestParam(value = "start", defaultValue = "0") int start,
                               Model model) {
        model.addAttribute("questionCategoryPage", questionCategoryService.getQuestionCategoryList(start));
        return "admin/question-categories/list";
    }

    //문제 카테고리 추가하기
    @GetMapping("/edit")
    public String addQuestionCategory(Model model) {
        model.addAttribute("questionCategoryPage", questionCategoryService.getQuestionCategoryList(0));
        return "admin/question-categories/edit";
    }

    @PostMapping("/edit")
    public String addQuestionCategory(@ModelAttribute QuestionCategory questionCategory) {
        questionCategoryService.addQuestionCategory(questionCategory);
        return "redirect:/admin/question-categories";
    }

    //문제 카테고리 삭제하기
    @DeleteMapping("/{questionCategoryId}")
    public String deleteQuestionCategory(@PathVariable Long questionCategoryId) {
        questionCategoryService.deleteQuestionCategory(questionCategoryId);
        return "redirect:/admin/question-categories";
    }

}
