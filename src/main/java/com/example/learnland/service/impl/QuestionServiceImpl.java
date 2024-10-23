package com.example.learnland.service.impl;

import com.example.learnland.models.Question;

import com.example.learnland.models.Response;
import com.example.learnland.repositories.QuestionRepository;
import com.example.learnland.repositories.ResponseRepository;
import com.example.learnland.service.AIService;
import com.example.learnland.service.QuestionService;
import com.example.learnland.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    AIService aiService;
    @Override
    public Question saveQuestion(Question question) throws IOException {
        Question save = questionRepository.save(question);
        Response response = new Response();
        response.setTextResponse(aiService.addMessage(save.getTextQuestion()));
        responseRepository.save(response);
        return save;
    }
}
