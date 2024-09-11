/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.repository;

import com.nva.pojo.Comment;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface CommentRepository {
    
    List<Comment> getComments();
}
