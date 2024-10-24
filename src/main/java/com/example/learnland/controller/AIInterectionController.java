package com.example.learnland.controller;

import com.example.learnland.models.AIInteraction;
import com.example.learnland.service.AIInterectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interection")
public class AIInterectionController {

    @Autowired
    AIInterectionService aiInterectionService;

    @GetMapping
    public List<AIInteraction> getInterection(){
        return aiInterectionService.getInterection();
    }
//    @GetMapping
//    public List<AIInteractionDTO> getInterectionDTO(){
//        return aiInterectionService.getInterectionDTO();
//    }
}
