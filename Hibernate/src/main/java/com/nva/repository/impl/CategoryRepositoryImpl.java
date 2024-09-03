/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.repository.impl;

import com.nva.hibernate.HibernateUtils;
import com.nva.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class CategoryRepositoryImpl {

    public List<Category> getCates() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            // Query q = s.createQuery("From Category", Category.class);
            
            Query q = s.createNamedQuery("Category.findAll", Category.class);

            return q.getResultList();
        }
    }
}
