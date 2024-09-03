/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nva.service;

import com.nva.pojo.User;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nguye
 */
public interface UserService {

    User getUserByUsername(String username);

    User addUser(Map<String, String> params, MultipartFile avatar);
}
