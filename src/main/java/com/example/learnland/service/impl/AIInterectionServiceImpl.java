package com.example.learnland.service.impl;

import com.example.learnland.dto.AIInteractionDTO;
import com.example.learnland.dto.mappers.AIInteractionMapper;
import com.example.learnland.models.AIInteraction;
import com.example.learnland.repositories.AIInterectionRepository;
import com.example.learnland.service.AIInterectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AIInterectionServiceImpl implements AIInterectionService {

    @Autowired
    AIInterectionRepository aiInterectionRepository;
    @Autowired
    AIInteractionMapper aiInteractionMapper;

    @Override
    public List<AIInteraction> getInterection() {
        return aiInterectionRepository.findAll();
    }

    @Override
    public List<AIInteractionDTO> getInterectionDTO() {
        List<AIInteraction> aiInteractions = aiInterectionRepository.findAll();
        return aiInteractions.stream().map(aiInteractionMapper ::toDTO).collect(Collectors.toList());
    }
}
