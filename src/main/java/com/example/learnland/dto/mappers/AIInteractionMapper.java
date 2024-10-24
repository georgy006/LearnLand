package com.example.learnland.dto.mappers;

import com.example.learnland.dto.AIInteractionDTO;
import com.example.learnland.models.AIInteraction;
import org.springframework.stereotype.Component;

@Component
public class AIInteractionMapper {
    public AIInteractionDTO toDTO(AIInteraction aiInteraction) {
        AIInteractionDTO dto = new AIInteractionDTO();
        dto.setResponseText(aiInteraction.getResponse().getTextResponse());
        dto.setQuestionText(aiInteraction.getQuestion().getTextQuestion());
        dto.setCreatedAt(aiInteraction.getCreatedAt().toString());
        return dto;
    }
}
