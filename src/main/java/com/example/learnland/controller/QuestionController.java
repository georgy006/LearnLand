package com.example.learnland.controller;

import com.example.learnland.models.Question;
import com.example.learnland.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public Question createQuestion(@RequestBody Question question) throws IOException {

        return questionService.saveQuestion(question);
    }
}
