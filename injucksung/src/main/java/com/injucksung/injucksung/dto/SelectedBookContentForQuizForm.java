package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectedBookContentForQuizForm {
    private Long[] bookContentIds;
    private String action;
}
