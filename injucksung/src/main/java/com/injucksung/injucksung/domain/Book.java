package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;


@Entity @Table(name = "book")
@Setter @Getter
@NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column
    private String publicationDate;

    @NonNull
    @Column(length = 100, nullable = false)
    private String author;

    @NonNull
    @Column(length = 100)
    private String isbn; //국제표준도서번호

    @NonNull
    @Column(nullable = false)
    private String publisher;
}
