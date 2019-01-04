package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookContentRepository extends JpaRepository<BookContent, Long> {
    //책 id로 검색하여 책 목차 조회하기
    List<BookContent> findBookContentByBookIdOrderByGroupIdAscSequenceAsc(Long bookId);

    //책 목차 id로 책목차 한건 조회하기
    BookContent findBookContentById(Long id);

    //문제 id로 책 목차 조회하기
    BookContent findBookContentByQuestionId(Long questionId);

    //현재 입력할려고 하는 책 목차의 sequece와 같거나 큰 sequence만 1씩 증가 (업데이트용)
//    @Query(value = "update BookContent bc set bc.sequence = bc.sequence+1 where bc.book.id = :bookId and bc.groupId = :groupId and bc.sequence >= :sequence")
//    @Modifying
//    @Query("update BookContent bc set bc.sequence = bc.sequence+1 where bc.groupId = 1 and bc.sequence > 2")
    @Query(value = "UPDATE book_content SET sequence = sequence+1", nativeQuery = true)
    void arrangeSequence();
}
