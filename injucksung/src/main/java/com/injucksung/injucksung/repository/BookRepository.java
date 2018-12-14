package com.injucksung.injucksung.repository;

import com.injucksung.injucksung.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
    //책 이름으로 검색하여 책 목록 조회하기
    Page<Book> findBookByNameContaining(String name, Pageable pageable);

    //책 id로 책 조회하기
    Book findBookById(Long id);
}

