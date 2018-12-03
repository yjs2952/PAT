package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResultRepository extends JpaRepository<Result, Long> {
    //result id로 Result 조회하기
    Result findResultById(Long id);

    //QuizRecordid로 Result 목록 조회하기
    Page<Result> findResultByQuizRecordId(Long quizRecordId, Pageable pageable);

    //특정 categoryId와 quizRecordId를 갖고있는 Result 목록 조회하기
//    @Query(value = "SELECT * FROM result r JOIN question q ON r.question_id = q.id WHERE q.category_id =:categoryId AND r.quiz_record_id=:quizRecordId", nativeQuery = true)
    @Query(value = "SELECT r FROM Result r INNER JOIN r.question WHERE quiz_record_id=:quizRecordId AND category_id =:categoryId")
    Page<Result> findResultByQuizRecordIdAndCategoryId(@Param("quizRecordId") Long quizRecordId, @Param("categoryId") Long categoryId, Pageable pageable);
}
