package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.*;
import org.junit.Assert;
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
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;
    @Autowired
    private BookContentRepository bookContentRepository;

    @Test
    public void bookContentId로_문제_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        //유형1 유의어 - id 6으로 조회
        Page<Question> questions = questionRepository.findQuestionByBookContentId(6L, pageable);
        Assert.assertEquals(2, questions.getTotalElements());
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
        System.out.println(questionRepository.findQuestionById(2L).getQuestionCategory());
    }

    @Test
    public void Question_한건_저장하기() throws Exception {
//        ContentFile contentFile = new ContentFile("위포트 언어 다의어 2번문제.pdf", "3535-4646-5757-6868", "PDF", "150", "/file/....");
//        ExplanationFile explanationFile = new ExplanationFile("위포트 언어 다의어 2번문제 해설.pdf", "0987-9877-8765-6543", "PDF", "100", "/file/....");
//
//        Question aptitudeQuestion = new Question(contentFile, explanationFile, 4, 0, 0, 5);
//        QuestionCategory questionCategoryById = questionCategoryRepository.findQuestionCategoryById(4L);
//        aptitudeQuestion.setQuestionCategory(questionCategoryById);
//        aptitudeQuestion.setBookContent(bookContentRepository.findBookContentById(7L));
//        aptitudeQuestion.setBookNumber(2);
//
//        questionRepository.save(aptitudeQuestion);
//        questionRepository.flush();
//
//        Assert.assertEquals(4L, questionRepository.findQuestionById(4L).getId().longValue());
    }

    @Test
    public void Question_한건_삭제하기() throws Exception {
        Long bookId = 1L;
        
        //문제 삭제
        questionRepository.deleteById(bookId);

        //삭제한 아이디로 조회하면 null이 나와야함
        Assert.assertNull(questionRepository.findQuestionById(bookId));
    }

    @Test
    public void 책목차id로_연관된_Question_모두_삭제하기() throws Exception {
        Long bookContentId = 6L;

        questionRepository.deleteByBookContentId(bookContentId);

        Assert.assertEquals(0, questionRepository.findQuestionByBookContentId(bookContentId,PageRequest.of(0, 5)).getTotalElements());
    }


}
