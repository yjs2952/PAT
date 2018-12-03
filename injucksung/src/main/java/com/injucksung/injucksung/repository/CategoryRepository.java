package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Category id로 Category 한건 조회하기
    Category findCategoryById(Long id);

    //상위 카테고리(superiorId)로 Category 목록 조회하기
    Set<Category> findCategoryBySuperiorId(Long superiorId);
}
