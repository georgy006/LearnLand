package com.example.learnland.service;

import com.example.learnland.dto.AIInteractionDTO;
import com.example.learnland.models.AIInteraction;

import java.util.List;

public interface AIInterectionService {
    List<AIInteraction> getInterection();
    List<AIInteractionDTO> getInterectionDTO();
}
