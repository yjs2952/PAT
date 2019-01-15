package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.LinkedList;
import java.util.List;

public interface BookContentRepository extends JpaRepository<BookContent, Long> {
    //책 id로 검색하여 책 목차 조회하기
    @Query(value = "SELECT bc FROM BookContent bc WHERE book_id = :bookId ORDER BY bc.depth, bc.sequence ASC")
    LinkedList<BookContent> findBookContentByBookId(@Param("bookId") Long bookId);

    //책 목차 id로 책목차 한건 조회하기
    BookContent findBookContentById(Long id);

    //대분류 인것만 가져오기
    @Query(value = "SELECT bc FROM BookContent bc JOIN bc.book b WHERE b.id = :bookId AND depth = 0")
    List<BookContent> findBookContentByDepthEqualsZero(@Param("bookId") Long bookId);

    //특정 SuperBookContentId의 + 특정 depth의 가장 큰 sequence값 가져오기
    @Query(value = "SELECT MAX(bc.sequence) FROM BookContent bc JOIN bc.superBookContent sp WHERE sp.id = :superBookContentId")
    int findMaxSequenceBySuperBookContentId(@Param("superBookContentId") Long superBookContentId);

    //TODO native 쿼리 JPQL로 바꾸기
    @Modifying
    @Query(value = "UPDATE book_content SET sequence = sequence - 1 WHERE super_book_content_id = :superBookContentId AND sequence > :sequence", nativeQuery = true)
    void arrangeSequencePull(@Param("superBookContentId") Long superBookContentId, @Param("sequence") Integer sequence);

    @Modifying
    @Query(value = "UPDATE book_content SET sequence = sequence - 1 WHERE book_id = :bookId AND sequence > :sequence AND depth = 0", nativeQuery = true)
    void arrangeSequencePullByDepthEqualsZero(@Param("bookId") Long bookId, @Param("sequence") Integer sequence);
}
