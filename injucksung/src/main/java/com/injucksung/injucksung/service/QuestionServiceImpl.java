package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import org.springframework.data.domain.Page;

public class QuestionServiceImpl implements QuestionService{
    @Override
    public int addQuestion(Question question) {
        return 0;
    }

    @Override
    public void deleteQuestion(Long questionId) {

    }

    @Override
    public int modifyQuestion(Question question) {
        return 0;
    }

    @Override
    public Page<Question> getQuestionList(Long bookContentId) {
        return null;
    }
}
