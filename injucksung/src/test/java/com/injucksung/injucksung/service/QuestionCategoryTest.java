package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.QuestionCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class QuestionCategoryTest {
    @Autowired
    private QuestionCategoryService questionCategoryService;

    @Test
    public void 문제카테고리_한건_추가하기() {
        long totalElements1 = questionCategoryService.getQuestionCategoryList(0).getTotalElements();

        QuestionCategory questionCategory = QuestionCategory.builder()
                .name("어법").parentId(1L).type("apt").build();
        questionCategoryService.addQuestionCategory(questionCategory);

        long totalElements2 = questionCategoryService.getQuestionCategoryList(0).getTotalElements();

        Assert.assertEquals(1, totalElements2 - totalElements1);
    }

}


