package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.enums.PageSize;
import com.injucksung.injucksung.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Book addBook(Book book) {
        Book addBook = bookRepository.save(book);
        return addBook;
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Book modifyBook(Book book) {
        Book bookById = bookRepository.findBookById(book.getId());
        BeanUtils.copyProperties(book, bookById);
        return bookById;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Book> getBookList(int start) {
        PageRequest pageRequest = PageRequest.of(start, PageSize.BOOK.getSize());
        Page<Book> books = bookRepository.findAll(pageRequest);
        return books;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Book> getBookList(int start, String searchType, String searchWord) {

        PageRequest pageRequest = PageRequest.of(start, PageSize.BOOK.getSize());
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
    @Transactional(readOnly = true)
    public Book getBook(Long id) {
        Book book = bookRepository.findBookById(id);
        return book;
    }
}
