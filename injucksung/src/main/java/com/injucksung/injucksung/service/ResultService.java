package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Result;
import org.springframework.data.domain.Page;

public interface ResultService {

    Page<Result> getResultList(Long QuizResultId, int start);

    int addResult(Result result);

    int modifyResult(Result result);

    void deleteResult(Long id);
}
