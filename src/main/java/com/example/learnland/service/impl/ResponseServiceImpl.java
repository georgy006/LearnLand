package com.example.learnland.service.impl;

import com.example.learnland.models.Response;
import com.example.learnland.repositories.ResponseRepository;
import com.example.learnland.service.AIService;
import com.example.learnland.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    AIService aiService;
    @Override
    public Response saveResponse(){
        return null;
    }
}
