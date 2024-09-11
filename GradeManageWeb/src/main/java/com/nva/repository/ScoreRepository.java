/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.repository;

import com.nva.pojo.Score;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface ScoreRepository {

    List<Score> getScores();
    
    List<Score> getScoreByVolumeId(int score_vol_Id);
}
