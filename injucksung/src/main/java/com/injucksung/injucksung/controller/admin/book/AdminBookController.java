package com.injucksung.injucksung.controller.admin.book;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
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
public class AdminBookController {
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
    @GetMapping("/add")
    public String addBook() {
        return "/admin/books/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/admin/books";
    }

    //책 정보 보기
    @GetMapping("/detail")
    public String bookDetail(@RequestParam("id") Long bookId,
                             @RequestParam(value = "addhighestbookcontent", defaultValue = "false") boolean addHighestBookContent,
                             Model model) {
        Book book = bookService.getBook(bookId);
        List<BookContent> bookContentList = bookContentService.getBookContentList(bookId);

        model.addAttribute("book", book);
        if (bookContentList != null) model.addAttribute("bookContentList", bookContentList);
        //대분류 추가 폼 표시 여부
        model.addAttribute("addHighestBookContent", addHighestBookContent);
        return "admin/books/detail";
    }

    //책 삭제하기
    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/admin/books";
    }
}
