/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.repository;

import com.nva.pojo.Volume;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface VolumeRepository {
    
    List<Volume> getVolumes();
    
    Volume getVolumeById(int id);
}
