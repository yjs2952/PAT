package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.BookContent;

import java.util.List;

public interface AdminBookContentService {
    void addBookContent(BookContent bookContent, Long bookId);

    void deleteBookContent(Long id);

    void modifyBookContent(BookContent bookContent);

    List<BookContent> getBookContentList(Long bookId);
}
