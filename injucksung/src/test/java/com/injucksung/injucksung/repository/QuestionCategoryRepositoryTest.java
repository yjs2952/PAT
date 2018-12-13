package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.injucksung.injucksung.repository.Print.print;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void id로_카테고리_한건_조회하기() throws Exception {
        Category category = categoryRepository.findCategoryById(4L);
        System.out.println(category.toString());
    }

    @Test
    public void parentId로_하위_카테고리_목록_조회하기() throws Exception {
        Set<Category> categorys = categoryRepository.findCategoryByParentId(1L);
        print(categorys);
    }
}
