/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Course;
import com.nva.repository.CourseRepository;
import com.nva.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<Course> getCourse() {
        return this.courseRepo.getCourse();
    }
}
