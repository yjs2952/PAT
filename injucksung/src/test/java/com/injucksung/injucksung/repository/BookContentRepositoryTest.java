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

import static com.injucksung.injucksung.repository.Print.print;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class BookContentRepositoryTest {
    @Autowired
    private BookContentRepository bookContentRepository;

    @Test
    public void bookId로_책목차_조회하기() throws Exception {
        List<BookContent> bookContents = bookContentRepository.findBookContentByBookId(1L);
        Assert.assertEquals(8, bookContents.size());
        for (BookContent bookContent : bookContents) {
            for (BookContent subBookContent : bookContent.getSubBookContents()) {
                System.out.println("서브"+subBookContent.getName());
            }
        }
    }

    @Test
    public void 책목차ID로_책목차_한건_조회하기() throws Exception {
        BookContent bookContentById = bookContentRepository.findBookContentById(4L);
        Assert.assertNotNull(bookContentById);
        System.out.println(bookContentById.getSuperBookContent().getName());
        for (BookContent subBookContent : bookContentById.getSubBookContents()) {
            System.out.println(subBookContent.getName());
        }
    }

}