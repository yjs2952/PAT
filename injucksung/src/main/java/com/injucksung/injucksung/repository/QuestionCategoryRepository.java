package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.QuestionCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Long> {
    QuestionCategory findQuestionCategoryById(Long id);
}

