package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.QuizRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRecordRepository extends JpaRepository<QuizRecord, Long> {
    //QuizRecord id로 QuizRecord 조회하기
    QuizRecord findQuizRecordById(Long id);


}
