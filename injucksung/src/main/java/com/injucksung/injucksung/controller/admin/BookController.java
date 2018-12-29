package com.injucksung.injucksung.controller.admin;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.dto.BookDetail;
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
@RequestMapping("/admin/books")
public class BookController {
    private final BookService bookService;
    private final BookContentService bookContentService;

    //책 리스트 가져오기
    @GetMapping
    public String bookList(@RequestParam(value = "start", defaultValue = "0") int start,
                           @RequestParam(value = "searchWord", defaultValue = "") String searchWord,
                           Model model) {
        Page<Book> bookList = bookService.getBookList(start);
        model.addAttribute("bookList", bookList.getContent());
        return "admin/books/list";
    }

    //책 등록하기
    @GetMapping("/edit")
    public String addBook() {
        return "/admin/books/edit";
    }

    @PostMapping("/edit")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/admin/books";
    }

    //책 수정하기
    @GetMapping("/edit/{bookId}")
    public String modifyBook(@PathVariable Long bookId, Model model) {
        model.addAttribute("book", bookService.getBook(bookId));
        return "/admin/books/edit";
    }

    @PutMapping("/edit/{bookId}")
    public String modifyBook(@ModelAttribute Book book) {
        bookService.modifyBook(book);
        return "redirect:/admin/books/"+book.getId();
    }

    //책 정보 상세 보기
    @GetMapping("/{bookId}")
    public String bookDetail(@PathVariable Long bookId,
                             @ModelAttribute BookDetail bookDetail,
                             Model model) {
        //책 데이터
        model.addAttribute("book", bookService.getBook(bookId));

        //책의 책목차 데이터
        List<BookContent> bookContentList = bookContentService.getBookContentList(bookId);
        if (bookContentList != null) model.addAttribute("bookContentList", bookContentList);

        //대분류 추가 폼 표시 여부 & 특정 책목차의 하위 목차 추가 폼 표시 여부
        model.addAttribute("bookDetail", bookDetail);

        return "admin/books/detail";
    }

    //책 삭제하기
    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/admin/books";
    }
}
