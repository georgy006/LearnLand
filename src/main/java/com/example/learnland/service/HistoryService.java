package com.example.learnland.service;

import com.example.learnland.dto.HistoryDTO;
import com.example.learnland.models.History;

import java.util.List;

public interface HistoryService {
    List<HistoryDTO> getAllHistory();
    HistoryDTO saveHistory(HistoryDTO historyDTO);
    HistoryDTO getHistoryById(Long id);
    void deleteHistoryById(Long id);
}
