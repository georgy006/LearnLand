package com.example.learnland.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface AIService {
    String sendMessage(String prompt, String question)throws IOException;
    void setPrompt(String prompt);
    String addMessage(String question) throws IOException;
    String getBalance() throws IOException;
}
