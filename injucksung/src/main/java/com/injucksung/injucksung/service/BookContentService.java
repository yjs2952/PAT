package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.BookContent;
import com.injucksung.injucksung.dto.BookContentForm;

import java.util.List;

public interface BookContentService {
    BookContent addBookContent(BookContentForm bookContentForm);

    void deleteBookContent(Long id);

    int modifyBookContent(BookContent bookContent);

    List<BookContent> getBookContentList(Long bookId);

    BookContent getBookContent(Long bookContentId);
}
