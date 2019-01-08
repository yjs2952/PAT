package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.dto.BookContentForm;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookContentServiceImpl implements BookContentService {
    private final BookContentRepository bookContentRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public BookContent addBookContent(BookContentForm bookContentForm) {
        BookContent bookContent = new BookContent();
        BeanUtils.copyProperties(bookContentForm, bookContent);

        bookContent.setBook(bookRepository.findBookById(bookContentForm.getBookId()));

        return bookContentRepository.save(bookContent);
    }

    @Override
    @Transactional
    public void deleteBookContent(Long id) {
        bookContentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public int modifyBookContent(BookContent bookContent) {
//        BookContent modifyBookContent = bookContentRepository.save(bookContent);
//        if (modifyBookContent != null) {
//            bookContentRepository.flush();
//            return 1;
//        }
//
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookContent> getBookContentList(Long bookId) {
        return bookContentRepository.findBookContentByBookId(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public BookContent getBookContent(Long bookContentId) {
        return bookContentRepository.findBookContentById(bookContentId);
    }
}
