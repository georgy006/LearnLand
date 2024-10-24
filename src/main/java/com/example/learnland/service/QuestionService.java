package com.example.learnland.service;

import com.example.learnland.models.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionService {
    Question saveQuestion (Question question) throws IOException;
    List<Question> getAllQuestion ();
    Question getQuestionById(Long id);

}
