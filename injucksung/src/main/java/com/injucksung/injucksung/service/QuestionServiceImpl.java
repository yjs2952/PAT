package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    @Transactional
    public int addQuestion(Question question) {
        return 0;
    }

    @Override
    @Transactional
    public void deleteQuestion(Long questionId) {

    }

    @Override
    @Transactional
    public int modifyQuestion(Question question) {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Question> getQuestionList(Long bookContentId) {
        return null;
    }
}
