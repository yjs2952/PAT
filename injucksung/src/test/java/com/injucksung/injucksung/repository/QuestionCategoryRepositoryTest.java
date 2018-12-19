package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.QuestionCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class QuestionCategoryRepositoryTest {
    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;

    @Test
    public void 카테고리id로_카테고리한건_조회하기() throws Exception {
        QuestionCategory questionCategoryById = questionCategoryRepository.findQuestionCategoryById(1L);
        Assert.assertNotNull(questionCategoryById);
    }

}