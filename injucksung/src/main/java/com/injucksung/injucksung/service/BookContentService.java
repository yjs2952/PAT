package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.BookContent;

import java.util.List;

public interface BookContentService {
    int addBookContent(BookContent bookContent, Long bookId);

    void deleteBookContent(Long id);

    int modifyBookContent(BookContent bookContent);

    List<BookContent> getBookContentList(Long bookId);
}
