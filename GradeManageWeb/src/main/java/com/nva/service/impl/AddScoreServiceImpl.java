/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.AddScore;
import com.nva.repository.AddScoreRepository;
import com.nva.service.AddScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class AddScoreServiceImpl implements AddScoreService {
    
    @Autowired
    private AddScoreRepository addRepo;

    @Override
    public List<AddScore> getAddScore() {
        return this.addRepo.getAddScore();
    }
    
}
