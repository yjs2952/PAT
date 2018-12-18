package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Result;
import org.springframework.data.domain.Page;

public class ResultServiceImpl implements ResultService {

    @Override
    public Page<Result> getResultList(Long QuizResultId, int start) {
        return null;
    }

    @Override
    public int addResult(Result result) {
        return 0;
    }

    @Override
    public int modifyResult(Result result) {
        return 0;
    }

    @Override
    public void deleteResult(Long id) {

    }
}
