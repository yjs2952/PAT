package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.AptitudeQuestion;
import com.injucksung.injucksung.domain.Question;
import org.springframework.data.domain.Page;

public interface QuestionService {
    int addQuestion(AptitudeQuestion question);

    void deleteQuestion(Long questionId);

    int modifyQuestion(AptitudeQuestion question);

    Page<AptitudeQuestion> getQuestionList(Long bookContentId);
}
