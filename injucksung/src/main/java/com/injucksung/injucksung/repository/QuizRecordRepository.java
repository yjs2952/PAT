package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.QuizRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizRecordRepository extends JpaRepository<QuizRecord, Long> {
    //유저 한명의 시험 목록(QuizRecord) 가져오기
    @Query(value = "SELECT qr FROM QuizRecord qr WHERE user_id = :userId")
    Page<QuizRecord> findQuizRecordByUserId(@Param("userId") Long userId, Pageable pageable);
}
