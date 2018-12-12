package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@Entity
@Table(name = "book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date publicationDate;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(length = 100)
    private String ISBN; //국제표준도서번호

    @Column(nullable = false)
    private String publisher;
}
