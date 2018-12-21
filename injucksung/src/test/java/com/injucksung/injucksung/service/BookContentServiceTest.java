package com.injucksung.injucksung.service;

import com.injucksung.injucksung.domain.Book;
import com.injucksung.injucksung.domain.BookContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.injucksung.injucksung.repository.Print.print;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@ComponentScan
public class BookContentServiceTest {
    @Autowired
    private BookContentService bookContentService;

    @Test
    public void 책목차_책ID로_조회하기() throws Exception {
        List<BookContent> bookContentList = bookContentService.getBookContentList(1L);
        print(bookContentList);
    }

    @Test
    public void 책_목차_한건_저장하기() throws Exception {
        BookContent bookContent = new BookContent(new Book(),"유형3 단어관계", 4L, 1, false);
        bookContentService.addBookContent(bookContent,1L);
        this.책목차_책ID로_조회하기();
    }
//
//    @Test
//    public void 책_수정하기() throws Exception {
//        Book book = new Book("인적성의 신", "2018.12.14", "유어스토리", "4949303049", "신출판사");
//        book.setId(1L);
//        bookService.updateBook(book);
//        this.책_모든_목록_조회하기();
//    }
//
//    @Test
//    public void 책_삭제하기() throws Exception {
//        bookService.deleteBook(2L);
//        System.out.println("------------");
//        this.책_모든_목록_조회하기();
//    }

}


