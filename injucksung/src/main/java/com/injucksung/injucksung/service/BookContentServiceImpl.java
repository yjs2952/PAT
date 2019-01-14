package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.dto.BookContentForm;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
        arrangeSequencePull(id);
        bookContentRepository.deleteById(id);
    }

    //삭제 시에 sequence (정렬 순서) 재정렬
    private void arrangeSequencePull(Long id) {
        BookContent bookContentById = bookContentRepository.findBookContentById(id);
        Integer sequence = bookContentById.getSequence();
        Long superBookContentId = bookContentById.getSuperBookContent().getId();
        bookContentRepository.arrangeSequencePull(superBookContentId, sequence);
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
        return sortBookContents(bookContentRepository.findBookContentByBookId(bookId));
    }

    private List<BookContent> sortBookContents(List<BookContent> bookContentList) {
        //TODO 책 목차 정렬하는 알고리즘 고민중 (현재 정렬 잘 안됨)
        for (int i = 0; i < bookContentList.size(); i++) {
            BookContent bookContent = bookContentList.get(i);
            BookContent superBookContent = bookContent.getSuperBookContent();
            if (superBookContent != null) {
                Collections.swap(bookContentList,
                        i, bookContentList.indexOf(superBookContent) + 1 + bookContent.getSequence());
            }
        }

        return bookContentList;
    }

    @Override
    @Transactional(readOnly = true)
    public BookContent getBookContent(Long bookContentId) {
        return bookContentRepository.findBookContentById(bookContentId);
    }
}
