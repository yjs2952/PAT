package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.QuizRecord;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class QuizRecordRepositoryTest {
    @Autowired
    private  QuizRecordRepository quizRecordRepository;

    @Test
    public void 유저아이디로_시험목록_가져오기() {
        Pageable pageable = PageRequest.of(0, 5);
        Long userId = 2L;
        Page<QuizRecord> quizRecordByUserId = quizRecordRepository.findQuizRecordByUserId(userId, pageable);
        Assert.assertEquals(1, quizRecordByUserId.getTotalElements());
        print(quizRecordByUserId);
    }
}

