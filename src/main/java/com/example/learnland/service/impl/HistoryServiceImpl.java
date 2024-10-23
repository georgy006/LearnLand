package com.example.learnland.service.impl;

import com.example.learnland.dto.HistoryDTO;
import com.example.learnland.dto.mappers.HistoryMapper;
import com.example.learnland.models.History;
import com.example.learnland.repositories.HistoryRepository;
import com.example.learnland.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    HistoryRepository historyRepository;

    @Override
    public List<HistoryDTO> getAllHistory() {
        List<History> histories = historyRepository.findAll();
        return histories.stream().map(historyMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HistoryDTO saveHistory(HistoryDTO historyDTO) {
        History history = new History();
        history = historyRepository.save(history);
        return historyMapper.toDTO(history);
    }

    @Override
    public HistoryDTO getHistoryById(Long id) {

        return historyRepository.findById(id)
                .map(historyMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deleteHistoryById(Long id) {
        historyRepository.deleteById(id);
    }
}
