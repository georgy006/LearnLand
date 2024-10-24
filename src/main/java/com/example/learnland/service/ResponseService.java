package com.example.learnland.service;

import com.example.learnland.models.Response;

import java.util.List;

public interface ResponseService {
    Response saveResponse();
    List<Response> getAllResponse ();
    Response getResponseById(Long id);
}
