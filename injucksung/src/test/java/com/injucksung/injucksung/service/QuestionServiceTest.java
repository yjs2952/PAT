package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.*;
import com.injucksung.injucksung.repository.BookContentRepository;
import com.injucksung.injucksung.repository.QuestionCategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.injucksung.injucksung.repository.Print.print;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@ComponentScan
public class QuestionServiceTest {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;
    @Autowired
    private BookContentRepository bookContentRepository;

    @Test
    public void 문제_하나_추가하기() throws Exception {
        //샘플데이터
        ContentFile contentFile = new ContentFile("위포트 언어 다의어 2번문제.pdf", "3535-4646-5757-6868", "PDF", "150", "/file/....");
        ExplanationFile explanationFile = new ExplanationFile("위포트 언어 다의어 2번문제 해설.pdf", "0987-9877-8765-6543", "PDF", "100", "/file/....");
        AptitudeQuestion aptitudeQuestion = new AptitudeQuestion(contentFile, explanationFile, 4, 0, 0, 5);
        QuestionCategory questionCategoryById = questionCategoryRepository.findQuestionCategoryById(4L);
        aptitudeQuestion.setQuestionCategory(questionCategoryById);
        aptitudeQuestion.setBookContent(bookContentRepository.findBookContentById(7L));
        aptitudeQuestion.setBookNumber(2);

        Assert.assertEquals(1, questionService.addQuestion(aptitudeQuestion));
    }

    @Test
    public void 문제_하나_수정하기() throws Exception {
        //샘플데이터
        ContentFile contentFile = new ContentFile("위포트 언어 다의어 2번문제.pdf", "3535-4646-5757-6868", "PDF", "150", "/file/....");
        ExplanationFile explanationFile = new ExplanationFile("위포트 언어 다의어 2번문제 해설.pdf", "0987-9877-8765-6543", "PDF", "100", "/file/....");
        AptitudeQuestion aptitudeQuestion = new AptitudeQuestion(contentFile, explanationFile, 4, 0, 0, 5);
        QuestionCategory questionCategoryById = questionCategoryRepository.findQuestionCategoryById(4L);
        aptitudeQuestion.setQuestionCategory(questionCategoryById);
        aptitudeQuestion.setBookContent(bookContentRepository.findBookContentById(7L));
        aptitudeQuestion.setBookNumber(2);

        Assert.assertEquals(1, questionService.modifyQuestion(aptitudeQuestion));
    }

    @Test
    public void 문제_하나_제거하기() throws Exception {
        questionService.deleteQuestion(1L);
    }

    @Test
    public void 문제_리스트_가져오기() throws Exception {
        Page<Question> questionList = questionService.getQuestionList(6L);
        Assert.assertEquals(2, questionList.getTotalElements());
    }

}


