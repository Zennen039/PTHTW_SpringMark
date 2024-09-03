/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.repository;

import com.nva.pojo.User;

/**
 *
 * @author nguye
 */
public interface UserRepository {

    User getUserByUsername(String username);
    
    User addUser(User user);
}
