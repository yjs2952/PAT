package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "aptitude_question")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("apt")
public class AptitudeQuestion extends Question {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "content_file_id")
    private ContentFile contentFile; //지문

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "explanation_file_id")
    private ExplanationFile explanataionFile; //해설

    @Column(nullable = false)
    private int correct; //정답인 보기

    @Column(nullable = false, columnDefinition = "int default 0")
    private int tryCount; //문제를 시도한 횟수

    @Column(nullable = false, columnDefinition = "int default 0")
    private int correctCount; //문제를 맞춘 횟수

    @Column(nullable = false)
    private int choiceCount; //4지선다인지 5지선다인지
}
