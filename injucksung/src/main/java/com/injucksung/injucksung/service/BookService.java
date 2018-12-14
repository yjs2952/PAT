package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;

import java.util.List;

public interface BookService {
    int addBook();
    int deleteBook(Long Id);
    int updateBook();
    List<Book> getBookList();
    Book getBook(Long Id);
}
