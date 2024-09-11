/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.repository;

import com.nva.pojo.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author nguye
 */
public interface UserRepository {
    
    User getUserByUsername(String username);
    
    User getUserById(int id);
    
    List<User> getUser();
    
    List<User> getUser(Map<String, String> params);
    
    List<User> findByUserRole(String userRole);
    
    Optional<User> findByUserId(int id);
    
    void deleteUser(int id);
    
    boolean authUser(String username, String password);
    
    User addUser(User user);
}
