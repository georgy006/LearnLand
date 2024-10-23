package com.example.learnland.dto.mappers;

import com.example.learnland.dto.HistoryDTO;
import com.example.learnland.models.AIInteraction;
import com.example.learnland.models.History;
import com.example.learnland.repositories.AIInterectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryMapper {
    @Autowired
    private AIInterectionRepository aiInteractionRepository;

    public HistoryDTO toDTO(History history) {
        HistoryDTO dto = new HistoryDTO();
        dto.setId(history.getHistoryId());
        dto.setInteractionId(history.getInteraction().getInteractionId());
        dto.setDescription(history.getDescription());
        dto.setCreatedAt(history.getCreatedAt().toString());
        return dto;
    }
    public History toEntity(HistoryDTO dto) {
        History history = new History();
        history.setDescription(dto.getDescription());

        AIInteraction interaction = aiInteractionRepository.findById(dto.getInteractionId()).orElse(null);
        history.setInteraction(interaction);

        return history;
    }
}
