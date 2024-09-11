/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.controllers;

import com.nva.service.ScoreService;
import com.nva.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author nguye
 */
@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private VolumeService volService;

    @GetMapping("/subjectdetails/{id}")
    public String getSubjectDetails(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("volume", this.volService.getVolumeById(id));

        model.addAttribute("score", this.scoreService.getScoreByVolumeId(id));

        return "subjectdetails";
    }
}
