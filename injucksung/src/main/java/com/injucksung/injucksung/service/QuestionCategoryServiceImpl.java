package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.QuestionCategory;
import com.injucksung.injucksung.enums.Page;
import com.injucksung.injucksung.repository.QuestionCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestionCategoryServiceImpl implements QuestionCategoryService {
    private final QuestionCategoryRepository questionCategoryRepository;

    @Override
    @Transactional
    public QuestionCategory addQuestionCategory(QuestionCategory questionCategory) {
        QuestionCategory addQuestionCategory = questionCategoryRepository.save(questionCategory);
        return addQuestionCategory;
    }

    @Override
    @Transactional
    public void deleteQuestionCategory(Long id) {
        questionCategoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public int modifyQuestionCategory(QuestionCategory questionCategory) {
        QuestionCategory modifyQuestionCategory = questionCategoryRepository.save(questionCategory);
        if (modifyQuestionCategory!=null) {
            questionCategoryRepository.flush();
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public org.springframework.data.domain.Page getQuestionCategoryList(int start) {
        PageRequest pageRequest = PageRequest.of(start, Page.QUESTION_CATEGORY.getSize());
        org.springframework.data.domain.Page questionCategories = questionCategoryRepository.findAll(pageRequest);
        return questionCategories;
    }
}
