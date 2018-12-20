package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.AptitudeQuestion;
import com.injucksung.injucksung.domain.Question;
import com.injucksung.injucksung.domain.QuestionCategory;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.QuestionCategoryRepository;
import com.injucksung.injucksung.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;
    private QuestionCategoryRepository questionCategoryRepository;
    private BookContentRepository bookContentRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuestionCategoryRepository questionCategoryRepository, BookContentRepository bookContentRepository) {
        this.questionRepository = questionRepository;
        this.questionCategoryRepository = questionCategoryRepository;
        this.bookContentRepository = bookContentRepository;
    }

    @Override
    @Transactional
    public int addQuestion(AptitudeQuestion question) {
        //실제로 들어온 정보는 아이디 뿐이라고 생각되어서,id로 실제 데이터 조회 후 set해주는 과정
        question.setBookContent(bookContentRepository.findBookContentById(question.getBookContent().getId()));
        question.setQuestionCategory(questionCategoryRepository.findQuestionCategoryById(question.getBookContent().getId()));

        AptitudeQuestion save = questionRepository.save(question);
        if (save != null) {
            questionRepository.flush();
            return 1;
        }
        return 0;
    }

    @Override
    @Transactional
    public void deleteQuestion(Long questionId) {

    }

    @Override
    @Transactional
    public int modifyQuestion(AptitudeQuestion question) {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AptitudeQuestion> getQuestionList(Long bookContentId) {
        return null;
    }
}
