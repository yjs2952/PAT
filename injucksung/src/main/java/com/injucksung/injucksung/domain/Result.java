package com.injucksung.injucksung.domain;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "result")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_record_id", nullable = false)
    private QuizRecord quizRecord;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @Column(nullable = false)
    private Boolean isCorrect;

    @Column(length = 1, nullable = false)
    private int checkedChoice;
}