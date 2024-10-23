package com.example.learnland.service.impl;

import com.example.learnland.models.AIInteraction;
import com.example.learnland.repositories.AIInterectionRepository;
import com.example.learnland.service.AIInterectionService;
import com.example.learnland.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIInterectionServiceImpl implements AIInterectionService {

    @Autowired
    AIInterectionRepository aiInterectionRepository;
    @Autowired
    AIService aiService;
    @Override
    public AIInteraction createInterection(String question) {
        return null;
    }
}
