package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@Entity
@Table(name = "quiz_record")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuizRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int correctCount;//맞힌 문제 문항수

    @Column(nullable = false)
    private int totalCount;//전체 문제 문항수

    @Column(nullable = false)
    private int time; //실제 걸린 시간 (단위 초)

    @Column (nullable = false)
    private String title;

    @Column
    private String book;
}

