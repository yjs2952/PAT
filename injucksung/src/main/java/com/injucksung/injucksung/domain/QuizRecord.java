package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity @Table(name = "quiz_record")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode
public class QuizRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;

    @Column(nullable = false)
    private int correctCount;//맞힌 문제 문항수

    @Column(nullable = false)
    private int totalCount;//전체 문제 문항수

    @Column(nullable = false)
    private int time; //실제 걸린 시간 (단위 초)

    @Column (nullable = false)
    private String title;
}

