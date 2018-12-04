package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("apt")
public class AptitudeQuestion extends Question{
    @ManyToMany
    @JoinTable(name = "question_passage",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "passage_id"))
    private Set<Passage> passages;

    @OneToMany
    @JoinColumn(name = "question_id")
    private Set<Choice> choices;

    private int score;
}
