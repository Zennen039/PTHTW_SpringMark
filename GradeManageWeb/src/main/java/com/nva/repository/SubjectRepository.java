/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.repository;

import com.nva.pojo.Subject;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface SubjectRepository {

    List<Subject> getSubjects(Map<String, String> params);

    void addOrUpdate(Subject sj);

    Subject getSubjectById(int id);

    void deleteSubject(int id);
}
