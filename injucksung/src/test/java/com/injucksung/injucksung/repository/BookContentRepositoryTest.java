package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.BookContent;
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
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookContentRepositoryTest {
    @Autowired
    private BookContentRepository bookContentRepository;

    @Test
    public void bookId로_책목차_조회하기() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);

        Page<BookContent> bookContents = bookContentRepository.findBookContentByBookId(1L, pageable);
        print(bookContents);
    }

    @Test
    public void id로_책목차_한건_조회하기() throws Exception {
        BookContent bookContent = bookContentRepository.findBookContentById(3L);
        System.out.println(bookContent.toString());
    }
}