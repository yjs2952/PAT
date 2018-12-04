package com.injucksung.injucksung.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("per")
public class PersonalityQuestion extends Question{
    @Column(length = 1)
    private int score; //1~5의 정수가 들어간다.
}
