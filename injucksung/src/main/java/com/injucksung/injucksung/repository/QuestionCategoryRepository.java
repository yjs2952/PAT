package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.QuestionCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Long> {
    //문제카테고리 id로 책 조회하기
    Book findBookById(Long id);
}

