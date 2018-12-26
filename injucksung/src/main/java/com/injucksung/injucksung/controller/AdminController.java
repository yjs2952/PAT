package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private BookService bookService;

    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin")
    public String adminMain() {
        return "admin/index";
    }

    //책 리스트 가져오기
    @GetMapping("/admin/book/list")
    public String bookList(@RequestParam(value = "start", defaultValue = "0") int start,
                           @RequestParam(value = "searchWord", defaultValue = "") String searchWord,
                           Model model) {
        Page<Book> bookList = bookService.getBookList(start);
        model.addAttribute("bookList", bookList.getContent());
        return "admin/book/list";
    }

    //책 등록하기
    @GetMapping("/admin/book/add")
    public String addBook() {
        return "/admin/book/add";
    }
    @PostMapping("/admin/book/add")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/admin/book/list";
    }

    @GetMapping("/admin/question/list")
    public String question() {
        return "admin/question/list";
    }
}
