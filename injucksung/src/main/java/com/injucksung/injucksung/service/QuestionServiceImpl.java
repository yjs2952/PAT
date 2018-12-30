package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.dto.QuestionForm;
import com.injucksung.injucksung.enums.PageSize;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.QuestionCategoryRepository;
import com.injucksung.injucksung.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
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
        //실제로 들어온 정보는 아이디 뿐이라고 생각되어서,id로 실제 데이터 조회 후 set해주는 과정
//        question.setBookContent(bookContentRepository.findBookContentById(question.getBookContent().getId()));
//        question.setQuestionCategory(questionCategoryRepository.findQuestionCategoryById(question.getBookContent().getId()));

//        Question save = questionRepository.save(question);
//        return save;
        return null;
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
