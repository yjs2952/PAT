package com.injucksung.injucksung.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class SubmittedQuizInfoDto {
    private Map<Long, Integer> selectedChoices;
    private int bookContentCount;

    public SubmittedQuizInfoDto(Map<String, String> selectedChoices) {
        selectedChoices.remove("_csrf");
        this.bookContentCount =  Integer.parseInt(selectedChoices.get("bookContentCount"));
        selectedChoices.remove("bookContentCount");

        this.selectedChoices = new HashMap<>();
        for (Map.Entry<String, String> selectedChoice : selectedChoices.entrySet()) {
            this.selectedChoices.put(Long.parseLong(selectedChoice.getKey()), Integer.parseInt(selectedChoice.getValue()));
        }
    }
}
