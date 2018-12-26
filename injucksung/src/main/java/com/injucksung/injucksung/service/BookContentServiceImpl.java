package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookContentServiceImpl implements BookContentService {
    private BookContentRepository bookContentRepository;
    private BookRepository bookRepository;

    public BookContentServiceImpl(BookContentRepository bookContentRepository, BookRepository bookRepository) {
        this.bookContentRepository = bookContentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public int addBookContent(BookContent bookContent, Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        bookContent.setBook(book);
        BookContent addBookContent = bookContentRepository.save(bookContent);
        if (addBookContent != null) {
            bookRepository.flush();
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional
    public void deleteBookContent(Long id) {
        bookContentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public int modifyBookContent(BookContent bookContent) {
        BookContent modifyBookContent = bookContentRepository.save(bookContent);
        if (modifyBookContent != null) {
            bookContentRepository.flush();
            return 1;
        }

        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookContent> getBookContentList(Long bookId) {
        List<BookContent> bookContents = bookContentRepository.findBookContentByBookIdOrderByParentIdAscSequenceAsc(1L);
        return bookContents;
    }
}
