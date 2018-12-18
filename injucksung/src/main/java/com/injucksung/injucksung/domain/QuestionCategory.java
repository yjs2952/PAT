package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "question_category")
@Setter @Getter
@NoArgsConstructor @RequiredArgsConstructor
public class QuestionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 100, nullable = false)
    private String name;

    @NonNull
    @Column
    private Long parentId;

    @NonNull
    @Column
    private String type; //인성 "per" 적성 "apt
}
