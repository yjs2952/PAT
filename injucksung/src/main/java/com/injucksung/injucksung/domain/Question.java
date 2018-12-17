package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "question")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public abstract class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_category_id", nullable = false)
    private QuestionCategory questionCategory; //문제 분류를 위한 카테고리

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_content_id", nullable = false)
    private BookContent bookContent; //책 목차

    @Column(nullable = false)
    private int bookNumber;
}
