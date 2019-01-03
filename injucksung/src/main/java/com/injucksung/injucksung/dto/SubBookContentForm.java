package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubBookContentForm {
    private Long bookContentId;
    private Long groupId;
    private Integer sequence;
    private Integer depth;
    private Long bookId;
}
