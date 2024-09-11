/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Score;
import com.nva.repository.ScoreRepository;
import com.nva.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepo;

    @Override
    public List<Score> getScores() {
        return this.scoreRepo.getScores();
    }

    @Override
    public List<Score> getScoreByVolumeId(int score_vol_Id) {
        return this.scoreRepo.getScoreByVolumeId(score_vol_Id);
    }
}
