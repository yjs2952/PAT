package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private final int PAGE_SIZE = 5;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public int addBook(Book book) {
        Book addBook = bookRepository.save(book);
        if (addBook != null) {
            bookRepository.flush();
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public int modifyBook(Book book) {
        Book modifyBook = bookRepository.save(book);
        if (modifyBook != null) {
            bookRepository.flush();
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Book> getBookList(int start) {
        PageRequest pageRequest = PageRequest.of(start, PAGE_SIZE);
        Page<Book> books = bookRepository.findAll(pageRequest);
        return books;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Book> getBookList(int start, String searchType, String searchWord) {

        PageRequest pageRequest = PageRequest.of(start, PAGE_SIZE);
        Page<Book> books = null;
        switch (searchType) {
            case "name":
                books = bookRepository.findBookByNameContaining(searchWord, pageRequest);
                break;
            case "author":
                books = bookRepository.findBookByAuthorContaining(searchWord, pageRequest);
                break;
            case "isbn":
                books = bookRepository.findBookByIsbnContaining(searchWord, pageRequest);
                break;
            case "publisher":
                books = bookRepository.findBookByPublisherContaining(searchWord, pageRequest);
                break;
            default:
                books = bookRepository.findAll(pageRequest);
        }
        return books;
    }

    @Override
    public Book getBook(Long id) {
        Book book = bookRepository.findBookById(id);
        return book;
    }
}
