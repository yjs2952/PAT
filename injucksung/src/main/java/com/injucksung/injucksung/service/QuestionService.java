package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.dto.QuestionForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuestionService {
    Question addQuestion(QuestionForm questionForm);

    void deleteQuestion(Long questionId);

    Question modifyQuestion(QuestionForm questionForm);

    List<Question> getQuestionList(Long bookContentId);

    Page<Question> getQuestionList(int start);
}
