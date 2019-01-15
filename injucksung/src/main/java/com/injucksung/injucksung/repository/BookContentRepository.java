package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookContentRepository extends JpaRepository<BookContent, Long> {
    //책 id로 검색하여 책 목차 조회하기
    @Query(value = "SELECT bc FROM BookContent bc WHERE book_id = :bookId ORDER BY bc.depth, bc.sequence ASC")
    List<BookContent> findBookContentByBookId(@Param("bookId") Long bookId);

    //책 목차 id로 책목차 한건 조회하기
    BookContent findBookContentById(Long id);

    //대분류 인것만 가져오기
    @Query(value = "SELECT bc FROM BookContent bc WHERE depth = 0")
    List<BookContent> findBookContentDepthEqualsZero();

    //특정 책의 + 특정 depth의 가장 큰 sequence값 가져오기
    @Query(value = "SELECT MAX(bc.sequence) FROM BookContent bc JOIN bc.book b WHERE b.id = :bookId AND bc.depth = :depth")
    int findMaxSequenceByBookIdAndDepth( @Param("bookId") Long bookId, @Param("depth") Integer depth);

    //    @Query("UPDATE BookContent bc SET bc.sequence = bc.sequence-1 WHERE bc.id in (SELECT bc1.id FROM BookContent bc1 LEFT JOIN bc1.supBookContent sbc WHERE bc.super_book_content_id = :superBookContentId AND bc.sequence > :sequence")
    @Modifying
    @Query(value = "UPDATE book_content SET sequence = sequence - 1 WHERE super_book_content_id = :superBookContentId AND sequence > :sequence", nativeQuery = true)
    void arrangeSequencePull(@Param("superBookContentId") Long superBookContentId, @Param("sequence") Integer sequence);
}
