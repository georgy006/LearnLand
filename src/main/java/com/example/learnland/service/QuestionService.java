package com.example.learnland.service;

import com.example.learnland.dto.HistoryDTO;
import com.example.learnland.models.Question;

import java.io.IOException;

public interface QuestionService {
    Question saveQuestion (Question question) throws IOException;

}
