package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
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

    @Test
    public void 문제_하나_추가하기() throws Exception {
        questionService.addQuestion();
    }

    @Test
    public void 문제_하나_수정하기() throws Exception {
        questionService.modifyQuestion();
    }

    @Test
    public void 문제_하나_제거하기() throws Exception {
        questionService.deleteQuestion();
    }

    @Test
    public void 문제_리스트_가져오기() throws Exception {
        questionService.getQuestionList();
    }

}


