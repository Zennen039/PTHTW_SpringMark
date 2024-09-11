/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Comment;
import com.nva.repository.CommentRepository;
import com.nva.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentRepository comRepo;

    @Override
    public List<Comment> getComments() {
        return this.comRepo.getComments();
    }
}
