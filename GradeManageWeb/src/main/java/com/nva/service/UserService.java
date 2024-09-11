/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.service;

import com.nva.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nguye
 */
public interface UserService extends UserDetailsService {
    
    User getUserByUsername(String username);
    
    User getUserById(int id);
    
    List<User> getUser();
    
    List<User> getAllUser(Map<String, String> params);
    
    List<User> getUserRole();
    
    void deleteUser(int id);
    
    boolean authUser(String username, String password);

    User addUser(Map<String, String> params, MultipartFile avatar);
}
