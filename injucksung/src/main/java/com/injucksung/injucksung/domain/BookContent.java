package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book_content")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private Long parentId;

    @Column(nullable = false)
    private int sequence;
}
