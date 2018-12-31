package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.dto.QuestionForm;
import com.injucksung.injucksung.enums.PageSize;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.QuestionCategoryRepository;
import com.injucksung.injucksung.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionCategoryRepository questionCategoryRepository;
    private final BookContentRepository bookContentRepository;

    @Override
    @Transactional
    public Question addQuestion(QuestionForm questionForm) {
        //TODO: 파일 업로드 구현

        Question question = new Question();
        BeanUtils.copyProperties(questionForm, question);

        question.setBookContent(bookContentRepository.findBookContentById(questionForm.getBookContentId()));
        question.setQuestionCategory(questionCategoryRepository.findQuestionCategoryById(questionForm.getQuestionCategoryId()));

        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long questionId) {

    }

    @Override
    @Transactional
    public Question modifyQuestion(QuestionForm questionForm) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Question> getQuestionList(Long bookContentId) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Question> getQuestionList(int start) {
        Pageable pageable = PageRequest.of(start, PageSize.QUESTION.getLimit());
        return questionRepository.findAll(pageable);
    }
}
