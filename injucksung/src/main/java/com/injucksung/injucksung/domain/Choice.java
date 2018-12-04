package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "choice")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean correct;
}
