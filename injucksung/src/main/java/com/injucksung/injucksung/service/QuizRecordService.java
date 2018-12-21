package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.QuizRecord;
import org.springframework.data.domain.Page;

public interface QuizRecordService {

    Page<QuizRecord> getQuizRecordList(int start);

    int addQuizRecordService(QuizRecord quizRecord);

    // TODO: 2018-12-18 이게 과연 필요할까?
    int modifyQuizRecordService(QuizRecord quizRecord);

    // TODO: 2018-12-18 이게 과연 필요할까? 
    void deleteQuizRecordService(Long id);
}
