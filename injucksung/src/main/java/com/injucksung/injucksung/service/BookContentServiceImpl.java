package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.BookRepository;
import lombok.RequiredArgsConstructor;
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
    public int addBookContent(BookContent bookContent, Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        bookContent.setBook(book);

        BookContent addBookContent = bookContentRepository.save(bookContent);

        //그룹id가 없는 경우 대분류일 경우라서 자신의 id를 그룹id로 갖는다.
        if (bookContent.getGroupId() == null) {
            bookContent.setGroupId(addBookContent.getId());
        }

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
        List<BookContent> bookContents = bookContentRepository.findBookContentByBookIdOrderByGroupIdAscSequenceAsc(bookId);
        return bookContents;
    }

    @Override
    @Transactional(readOnly = true)
    public BookContent getBookContent(Long bookContentId) {
        return bookContentRepository.findBookContentById(bookContentId);
    }
}
