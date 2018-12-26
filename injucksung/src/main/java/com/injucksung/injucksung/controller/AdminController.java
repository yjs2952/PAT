package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.service.BookContentService;
import com.injucksung.injucksung.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    private BookService bookService;
    private BookContentService bookContentService;

    public AdminController(BookService bookService, BookContentService bookContentService) {
        this.bookService = bookService;
        this.bookContentService = bookContentService;
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

    //책 정보 보기
    @GetMapping("/admin/book/detail")
    public String bookDetail(@RequestParam("id") Long bookId,
                       Model model) {
        Book book = bookService.getBook(bookId);
        List<BookContent> bookContentList = bookContentService.getBookContentList(bookId);

        model.addAttribute("book", book);
        if (bookContentList!=null) model.addAttribute("bookContentList", bookContentList);
        return "admin/book/detail";
    }

    //책 삭제하기
    @GetMapping("/admin/book/delete")
    public String deleteBook(@RequestParam("id") Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/admin/book/list";
    }

    //문제 리스트
    @GetMapping("/admin/question/list")
    public String question() {
        return "admin/question/list";
    }
}
