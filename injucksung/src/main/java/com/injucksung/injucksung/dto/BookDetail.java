package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookDetail {
    private boolean editTopBookContent;
    private int editSubBookContentId;

    //롬복 Getter로 미생성 되어 따로 명시
    public boolean isEditTopBookContent() {
        return editTopBookContent;
    }
}
