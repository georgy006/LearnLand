package com.example.learnland.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AIInteractionDTO {
    private String questionText;
    private String responseText;
    private String createdAt;
}
