package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.BookContent;

import java.util.List;

public interface BookContentService {
    void addBookContent(BookContent bookContent, Long bookId);

    void deleteBookContent(Long id);

    void updateBookContent(BookContent bookContent);

    List<BookContent> getBookContentList(Long bookId);
}
