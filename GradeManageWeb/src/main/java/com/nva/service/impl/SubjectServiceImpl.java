/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Subject;
import com.nva.repository.SubjectRepository;
import com.nva.service.SubjectService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subRepo;

    @Override
    public List<Subject> getSubjects(Map<String, String> params) {
        return this.subRepo.getSubjects(params);
    }

    @Override
    public void addOrUpdate(Subject sj) {
        this.subRepo.addOrUpdate(sj);
    }

    @Override
    public Subject getSubjectById(int id) {
        return this.subRepo.getSubjectById(id);
    }

    @Override
    public void deleteSubject(int id) {
        this.subRepo.deleteSubject(id);
    }
}
