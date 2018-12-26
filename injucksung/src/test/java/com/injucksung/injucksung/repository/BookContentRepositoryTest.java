package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.BookContent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class BookContentRepositoryTest {
    @Autowired
    private BookContentRepository bookContentRepository;

    @Test
    public void bookId로_책목차_조회하기() throws Exception {
        List<BookContent> bookContents = bookContentRepository.findBookContentByBookIdOrderByParentIdAscSequenceAsc(1L);
//        print(bookContents);
    }

    @Test
    public void 책_목차ID로_책목차_한건_조회하기() throws Exception {
        BookContent bookContentById = bookContentRepository.findBookContentById(1L);
        Assert.assertNotNull(bookContentById);
    }

}