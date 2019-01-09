package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    //result Id로 조회하기
    Result findResultById(Long resultId);

    //문제id로 관련 result 삭제하기
    void deleteByQuestionId(Long bookId);
}
