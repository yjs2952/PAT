package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import org.springframework.data.domain.Page;

public interface QuestionService {
    int addQuestion(Question question);

    void deleteQuestion(Long questionId);

    int modifyQuestion(Question question);

    Page<Question> getQuestionList(Long bookContentId);
}
