package com.example.movieservice.service;

import com.example.movieservice.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InfoService {

    @Autowired
    private MovieRepo movieRepo;

    public Map<String, Object> findFullInfoById(String id) {
        return movieRepo.getFullInfo(id).orElse(null);
    }

    public List<Map<String, Object>> findFullInfoByIds(List<String> ids) {
        return movieRepo.getFullInfoAll(ids);
    }
}
