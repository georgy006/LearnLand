package com.example.learnland.service.impl;

import com.example.learnland.models.Response;
import com.example.learnland.repositories.ResponseRepository;
import com.example.learnland.service.AIService;
import com.example.learnland.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Response> getAllResponse() {
        return responseRepository.findAll();
    }

    @Override
    public Response getResponseById(Long id) {
        return responseRepository.findById(id).orElse(null);
    }
}
