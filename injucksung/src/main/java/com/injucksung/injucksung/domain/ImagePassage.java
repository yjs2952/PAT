package com.injucksung.injucksung.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("img")
public class ImagePassage extends Passage{
    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String savedName;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String length;

    @Column(nullable = false)
    private String regDate;

    @Column(nullable = false)
    private String path;
}
