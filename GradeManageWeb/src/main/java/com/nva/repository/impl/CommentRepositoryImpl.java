/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.repository.impl;

import com.nva.pojo.Comment;
import com.nva.repository.CommentRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nguye
 */
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Comment> getComments() {
        Session s = this.factory.getObject().getCurrentSession();
        
        Query q = s.createNamedQuery("Comment.findAll");
        
        return q.getResultList();
    }
}
