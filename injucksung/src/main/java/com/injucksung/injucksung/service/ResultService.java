package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.domain.Result;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ResultService {

    Page<Result> getResultList(Long QuizResultId, int start);

    List<Result> addResult(Map<String, String> selectedChoices, QuizRecord quizRecord);

    int modifyResult(Result result);

    void deleteResult(Long id);
}
