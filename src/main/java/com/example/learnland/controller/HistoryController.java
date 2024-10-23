package com.example.learnland.controller;

import com.example.learnland.dto.HistoryDTO;
import com.example.learnland.models.History;
import com.example.learnland.repositories.HistoryRepository;
import com.example.learnland.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping
    public List<HistoryDTO> getAllHistory() {
        return historyService.getAllHistory();
    }
    @PostMapping
    public HistoryDTO createHistory(@RequestBody HistoryDTO historyDTO) {
        return historyService.saveHistory(historyDTO);
    }

    @GetMapping("/{id}")
    public HistoryDTO getHistoryById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHistoryById(@PathVariable Long id) {
        historyService.deleteHistoryById(id);
    }
}
