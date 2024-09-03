/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.service.impl;

import com.cloudinary.Cloudinary;
import com.nva.pojo.User;
import com.nva.repository.UserRepository;
import com.nva.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nguye
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User getUserByUsername(String username) {
        return this.userRepo.getUserByUsername(username);
    }

    @Override
    public User addUser(Map<String, String> params, MultipartFile avatar) {
        User u = new User();

        u.setFirstName(params.get("firstName"));
        u.setLastName(params.get("lastName"));
        u.setPhone(params.getOrDefault("phone", "9999999999"));
        u.setEmail(params.getOrDefault("email", "a@edu.vn"));
        u.setUsername(params.get("username"));
        u.setPassword(params.get("password"));
        u.setUserRole("ROLE_LECTURER");
        u.setUserRole("ROLE_STUDENT");

        this.userRepo.addUser(u);

        return u;
    }
}
