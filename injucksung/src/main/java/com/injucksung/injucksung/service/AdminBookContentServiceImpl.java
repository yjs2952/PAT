package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminBookContentServiceImpl implements AdminBookContentService {
    private BookContentRepository bookContentRepository;
    private BookRepository bookRepository;

    public AdminBookContentServiceImpl(BookContentRepository bookContentRepository, BookRepository bookRepository) {
        this.bookContentRepository = bookContentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public void addBookContent(BookContent bookContent, Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        bookContent.setBook(book);
        bookContentRepository.save(bookContent);
    }

    @Override
    @Transactional
    public void deleteBookContent(Long id) {
        bookContentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void modifyBookContent(BookContent bookContent) {
        bookContentRepository.save(bookContent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookContent> getBookContentList(Long bookId) {
        List<BookContent> bookContents = bookContentRepository.findBookContentByBookId(1L);
        return bookContents;
    }
}
