/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Enrollment;
import com.nva.pojo.User;
import com.nva.pojo.UserDetail;
import com.nva.repository.EnrollmentRepository;
import com.nva.repository.ScoreRepository;
import com.nva.repository.SubjectRepository;
import com.nva.repository.UserRepository;
import com.nva.repository.VolumeRepository;
import com.nva.service.UserDetailService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nguye
 */
public class UserDetailServiceImpl implements UserDetailService {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private SubjectRepository subRepo;
    
    @Autowired
    private EnrollmentRepository enRepo;
    
    @Autowired
    private VolumeRepository volRepo;
    
    @Autowired
    private ScoreRepository scoreRepo;
    
    public List<UserDetail> getUserDetail(int studentId) {
        User student = this.userRepo.findByUserId(studentId).orElse(null);
        
        if (student == null)
        {
            return new ArrayList<>();
        }
        
        List<UserDetail> userdetail = new ArrayList<>();
        
        return userdetail;
    }
}
