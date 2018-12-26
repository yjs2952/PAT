package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookContentRepository extends JpaRepository<BookContent, Long> {
    //책 id로 검색하여 책 목차 조회하기
    List<BookContent> findBookContentByBookIdOrderByParentIdAscSequenceAsc(Long bookId);

    //책 목차 id로 책목차 한건 조회하기
    BookContent findBookContentById(Long id);
}
