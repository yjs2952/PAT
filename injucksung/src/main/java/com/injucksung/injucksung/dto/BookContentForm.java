package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookContentForm {
    private String name;
    private boolean isMockTest;
    private Integer recommendTime;
    private Long bookId;
    private Long groupId;
    private Integer sequence;
    private Integer depth;
}
