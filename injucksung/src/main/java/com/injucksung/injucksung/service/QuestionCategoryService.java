package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.QuestionCategory;
import org.springframework.data.domain.Page;

public interface QuestionCategoryService {
    QuestionCategory addQuestionCategory(QuestionCategory questionCategory);

    void deleteQuestionCategory(Long id);

    int modifyQuestionCategory(QuestionCategory questionCategory);

    Page<QuestionCategory> getQuestionCategoryList(int start);

    //TODO:문제 카테고리 검색 기능이 굳이 필요할까?
//    Page<QuestionCategory> getQuestionCategoryList(int start, String searchType, String searchWord);
}
