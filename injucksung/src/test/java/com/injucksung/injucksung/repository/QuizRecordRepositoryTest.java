package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.QuizRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class QuizRecordRepositoryTest {
    @Autowired
    private QuizRecordRepository quizRecordRepository;

    @Test
    public void id로_QuizRecord_한건_조회하기() throws Exception {
        QuizRecord quizRecordById = quizRecordRepository.findQuizRecordById(1L);
        System.out.println(quizRecordById);
    }


}

