package com.example.learnland.controller;

import com.example.learnland.models.Question;
import com.example.learnland.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public Question createQuestion(@RequestBody Question question) throws IOException {
        return questionService.saveQuestion(question);
    }
    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestion();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionsById(@PathVariable Long id){
        Question question = questionService.getQuestionById(id);
        if (question != null) {
            return ResponseEntity.ok(question);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
