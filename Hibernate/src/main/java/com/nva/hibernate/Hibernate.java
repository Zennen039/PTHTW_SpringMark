/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nva.hibernate;

import com.nva.repository.impl.CategoryRepositoryImpl;

/**
 *
 * @author nguye
 */
public class Hibernate {

    public static void main(String[] args) {
        CategoryRepositoryImpl cr = new CategoryRepositoryImpl();
        
        cr.getCates().forEach(c -> System.out.println(c.getName()));
    }
}
