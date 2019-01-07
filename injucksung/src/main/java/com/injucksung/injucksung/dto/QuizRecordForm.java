package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizRecordForm {
    private String name;
    private Boolean isMockTest;
    private Integer recommendTime;
    private Long bookId;
    private Long groupId;
    private Integer sequence;
    private Integer depth;
    private Integer questionCount;
}
