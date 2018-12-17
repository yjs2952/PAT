package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.injucksung.injucksung.repository.Print.print;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void bookContentId로_문제_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Question> questions = questionRepository.findQuestionByBookContentId(6L, pageable);
        print(questions);
    }

    @Test
    public void bookId로_문제_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Question> questions = questionRepository.findQuestionByBookId(1L, pageable);
        print(questions);
    }

    @Test
    public void id로_문제_한건_조회하기() throws Exception {
        Question question = questionRepository.findQuestionById(2L);
        System.out.println(question.toString());
    }

    @Test
    public void questionId로_category_조회하기() throws Exception {
        System.out.println(questionRepository.findQuestionById(2L).getCategory());
    }
}
