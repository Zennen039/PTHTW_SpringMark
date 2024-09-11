/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Volume;
import com.nva.repository.VolumeRepository;
import com.nva.service.VolumeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class VolumeServiceImpl implements VolumeService {
    
    @Autowired
    private VolumeRepository volRepo;

    @Override
    public List<Volume> getVolumes() {
        return this.volRepo.getVolumes();
    }

    @Override
    public Volume getVolumeById(int id) {
        return this.volRepo.getVolumeById(id);
    }
}
