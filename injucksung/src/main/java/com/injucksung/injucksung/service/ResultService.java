package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.domain.Result;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ResultService {

    List<Result> getResults(Long quizRecordId);

    List<Result> addResult(Map<Long, Integer> selectedChoices, QuizRecord quizRecord);

    int modifyResult(Result result);

    void deleteResult(Long id);
}
