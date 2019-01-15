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
    private Long bookContentId;
    private Integer sequence;
    private Integer depth;
    private Integer questionCount;

    public void adjustFields() {
        this.depth = (depth == null) ? 0 : depth + 1;
        this.questionCount = 0;
    }
}
