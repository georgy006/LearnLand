package com.example.learnland.controller;

import com.example.learnland.models.Response;
import com.example.learnland.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ai-response")
public class ResponseController {
    @Autowired
    ResponseService responseService;
    @GetMapping
    public List<Response> getAllQuestions(){
        return responseService.getAllResponse();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getQuestionsById(@PathVariable Long id){
        Response response = responseService.getResponseById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
