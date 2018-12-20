package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionService;

    public QuestionServiceImpl(QuestionRepository questionService) {
        this.questionService = questionService;
    }

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
