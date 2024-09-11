/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Enrollment;
import com.nva.repository.EnrollmentRepository;
import com.nva.service.EnrollmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    
    @Autowired
    private EnrollmentRepository enRepo;

    @Override
    public List<Enrollment> getEnrollmets() {
        return this.enRepo.getEnrollmets();
    }
}
