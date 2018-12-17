package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminBookContentServiceImpl implements AdminBookContentService {
    private BookContentRepository bookContentRepository;
    private BookRepository bookRepository;

    public AdminBookContentServiceImpl(BookContentRepository bookContentRepository, BookRepository bookRepository) {
        this.bookContentRepository = bookContentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBookContent(BookContent bookContent, Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        bookContent.setBook(book);
        bookContentRepository.save(bookContent);
    }

    @Override
    public void deleteBookContent(Long id) {
        bookContentRepository.deleteById(id);
    }

    @Override
    public void modifyBookContent(BookContent bookContent) {
        bookContentRepository.save(bookContent);
    }

    @Override
    public List<BookContent> getBookContentList(Long bookId) {
        List<BookContent> bookContents = bookContentRepository.findBookContentByBookId(1L);
        return bookContents;
    }
}
