package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.domain.QuizRecord;
import com.injucksung.injucksung.domain.Result;
import com.injucksung.injucksung.repository.QuestionRepository;
import com.injucksung.injucksung.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;
    private final QuestionRepository questionRepository;

    @Override
    public Result getResult(Long resultId) {
        return resultRepository.findResultById(resultId);
    }

    @Override
    public List<Result> addResult(Map<Long, Integer> selectedChoices, QuizRecord quizRecord) {
        List<Result> results = new ArrayList<>();
        List<Question> questions = questionRepository.findQuestionById(selectedChoices.keySet());

        for (Question question : questions) {
            results.add(
                    Result.builder()
                    .isCorrect(question.getCorrect() == selectedChoices.get(question.getId()))
                    .checkedChoice(selectedChoices.get(question.getId()))
                    .question(question)
                    .quizRecord(quizRecord)
                    .build());
        }

        return resultRepository.saveAll(results);
    }

    @Override
    public int modifyResult(Result result) {
        return 0;
    }

    @Override
    public void deleteResult(Long id) {

    }
}
