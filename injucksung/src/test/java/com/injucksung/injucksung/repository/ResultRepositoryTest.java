package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.injucksung.injucksung.repository.Print.print;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ResultRepositoryTest {
    @Autowired
    private ResultRepository resultRepository;

    @Test
    public void 문제ID로_연관된_모든Result_삭제하기() {
        Long bookId = 1L;
        int sizeBefore = resultRepository.findAll().size();
        resultRepository.deleteByQuestionId(bookId);
        int sizeAfter = resultRepository.findAll().size();

        Assert.assertEquals(1, sizeBefore - sizeAfter);
    }
}
