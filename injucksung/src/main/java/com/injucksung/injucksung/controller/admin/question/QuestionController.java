package com.injucksung.injucksung.controller.admin.question;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.dto.BookDetail;
import com.injucksung.injucksung.service.BookContentService;
import com.injucksung.injucksung.service.BookService;
import com.injucksung.injucksung.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/questions")
public class QuestionController {
    private final QuestionService questionService;

    //책 리스트 가져오기
    @GetMapping
    public String QuestionList(@RequestParam(value = "start", defaultValue = "0") int start,
                           Model model) {
//        Page<Book> bookList = bookService.getBookList(start);
//        questionService.getQuestionList()
//        model.addAttribute("bookList", bookList.getContent());
        return "admin/books/list";
    }
}
