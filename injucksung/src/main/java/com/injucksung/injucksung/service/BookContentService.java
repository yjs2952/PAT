package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    void addBook(Book book);

    void deleteBook(Long id);

    void updateBook(Book book);

    Page<Book> getBookList(int start);

    Page<Book> getBookList(int start, String searchType, String searchWord);

    Book getBook(Long id);
}
