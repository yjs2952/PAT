package com.injucksung.injucksung.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("txt")
public class TextPassage extends Passage{
    @Column(nullable = false)
    private String content;
}
