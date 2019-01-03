package com.injucksung.injucksung.controller;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.dto.SubBookContentForm;
import com.injucksung.injucksung.service.BookContentService;
import com.injucksung.injucksung.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class UserBookController {
    private final BookService bookService;
    private final BookContentService bookContentService;

    //책 리스트 가져오기
    @GetMapping
    public String getBookList(@RequestParam(value = "start", defaultValue = "0") int start,
                              @RequestParam(value = "searchWord", defaultValue = "") String searchWord,
                              Model model) {
        Page<Book> bookList = bookService.getBookList(start);
        model.addAttribute("bookList", bookList.getContent());
        return "/users/books/list";
    }

    //책 정보 상세 보기
    @GetMapping("/{bookId}")
    public String getBookDetail(@PathVariable Long bookId,
                                Model model) {
        //책 데이터
        model.addAttribute("book", bookService.getBook(bookId));

        //책의 책목차 데이터
        List<BookContent> bookContentList = bookContentService.getBookContentList(bookId);
        if (bookContentList != null) model.addAttribute("bookContentList", bookContentList);

        return "/users/books/selectBookContent";
    }
}
