package com.example.learnland.service.impl;

import com.example.learnland.models.AIInteraction;
import com.example.learnland.models.Question;

import com.example.learnland.models.Response;
import com.example.learnland.repositories.AIInterectionRepository;
import com.example.learnland.repositories.QuestionRepository;
import com.example.learnland.repositories.ResponseRepository;
import com.example.learnland.service.AIService;
import com.example.learnland.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    AIInterectionRepository aiInterectionRepository;
    @Autowired
    AIService aiService;
    @Override
    public Question saveQuestion(Question question) throws IOException {
        Question save = questionRepository.save(question);
        Response response = new Response();
        response.setTextResponse(aiService.addMessage(save.getTextQuestion()));
        responseRepository.save(response);

        AIInteraction aiInteraction = new AIInteraction();
        aiInteraction.setQuestion(save);
        aiInteraction.setResponse(response);
        aiInteraction.setCreatedAt(LocalDateTime.now());
        aiInterectionRepository.save(aiInteraction);

        return save;
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }
}
