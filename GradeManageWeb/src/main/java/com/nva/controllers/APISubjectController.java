/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.controllers;

import com.nva.pojo.Subject;
import com.nva.service.SubjectService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nguye
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class APISubjectController {

    @Autowired
    private SubjectService subService;

    @DeleteMapping("/subjects/{subjectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "subjectId") int id) {
        this.subService.deleteSubject(id);
    }

    @GetMapping("/subjects/")
    public ResponseEntity<List<Subject>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.subService.getSubjects(params), HttpStatus.OK);
    }

    @GetMapping(path = "/subjects/{subjectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subject> retrieve(@PathVariable(value = "monhocId") int id) {
        return new ResponseEntity<>(this.subService.getSubjectById(id), HttpStatus.OK);
    }
}
