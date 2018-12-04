package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    @Column
    private int score;
}

