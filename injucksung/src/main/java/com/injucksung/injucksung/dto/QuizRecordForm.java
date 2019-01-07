package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookContentForm {
    private String name;
    private Boolean isMockTest;
    private Integer recommendTime;
    private Long bookId;
    private Long groupId;
    private Integer sequence;
    private Integer depth;
    private Integer questionCount;

    public BookContentForm(String name, Boolean isMockTest, Integer recommendTime, Long bookId, Long groupId, Integer sequence, Integer depth) {
        this.name = name;
        this.isMockTest = isMockTest;
        this.recommendTime = recommendTime;
        this.bookId = bookId;
        this.groupId = groupId;
        this.sequence = sequence;
        this.depth = depth;
        this.questionCount = 0;

        if (sequence == null) this.sequence = 0;
        if (depth == null) this.depth = 0;
    }
}
