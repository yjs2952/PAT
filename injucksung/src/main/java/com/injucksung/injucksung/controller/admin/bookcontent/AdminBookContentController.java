package com.injucksung.injucksung.controller.admin.bookcontent;

import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.service.BookContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/books")
public class AdminBookContentController {
    private final BookContentService bookContentService;

    //책 목차 추가하기
    @PostMapping("/admin/bookcontent/add")
    public String addBookContent(@ModelAttribute BookContent bookContent,
                                 @RequestParam("bookid") Long bookId) {
        bookContentService.addBookContent(bookContent, bookId);
        return "redirect:/admin/book/detail?id=" + bookId;
    }

    //책 하위 목차 추가하기
    @GetMapping("/admin/bookcontent/addsub")
    public String addBookContent(@RequestParam("bookcontentid") Long bookContentId, Model model) {
        model.addAttribute("parentBookContent", bookContentService.getBookContent(bookContentId));
        return "/admin/book/addSubBookContent";
    }

    @PostMapping("/admin/bookcontent/addsub")
    public String addBookContent(@RequestParam("bookId") Long bookId,
                                 @ModelAttribute BookContent bookContent) {
        bookContentService.addBookContent(bookContent, bookId);
        return "redirect:/admin/book/detail?id=" + bookId;
    }

    //문제 리스트
    @GetMapping("/admin/question/list")
    public String question() {
        return "admin/question/list";
    }
}
