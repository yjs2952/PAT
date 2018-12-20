package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.QuestionCategory;
import com.injucksung.injucksung.repository.QuestionCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

public class QuestionCategoryServiceImpl implements QuestionCategoryService {
    private QuestionCategoryRepository questionCategoryRepository;
    private final int PAGE_SIZE = 20;

    public QuestionCategoryServiceImpl(QuestionCategoryRepository questionCategoryRepository) {
        this.questionCategoryRepository = questionCategoryRepository;
    }

    @Override
    @Transactional
    public int addQuestionCategory(QuestionCategory questionCategory) {
        QuestionCategory addQuestionCategory = questionCategoryRepository.save(questionCategory);
        if (addQuestionCategory!=null) {
            questionCategoryRepository.flush();
            return 1;
        }
        return 0;
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
    public Page<QuestionCategory> getQuestionCategoryList(int start) {
        PageRequest pageRequest = PageRequest.of(start, PAGE_SIZE);
        Page<QuestionCategory> questionCategories = questionCategoryRepository.findAll(pageRequest);
        return questionCategories;
    }
}
