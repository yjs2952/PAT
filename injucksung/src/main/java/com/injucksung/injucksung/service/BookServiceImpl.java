package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private final int PAGE_SIZE = 5;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Page<Book> getBookList(int start) {
        PageRequest pageRequest = PageRequest.of(start, PAGE_SIZE);
        Page<Book> books = bookRepository.findAll(pageRequest);
        return books;
    }

    @Override
    public Book getBook(Long id) {
        Book book = bookRepository.findBookById(id);
        return book;
    }
}
