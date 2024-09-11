/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.nva.pojo.Forum;
import com.nva.repository.ForumRepository;
import com.nva.service.ForumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nguye
 */
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumRepository forumRepo;

    @Override
    public List<Forum> getForums() {
        return this.forumRepo.getForums();
    }
}
