package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectedBookContentForQuizForm {
    private Long[] bookContentId;
    private String action;
}
