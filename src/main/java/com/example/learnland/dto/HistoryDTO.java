package com.example.learnland.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoryDTO {
    private Long id;
    private Long interactionId;
    private String description;
    private String createdAt;
}
