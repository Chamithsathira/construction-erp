package com.cistem.constructionerp.controller;

import com.cistem.constructionerp.entity.UserDetailEntity;
import com.cistem.constructionerp.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is the controller for user authentications
 * @author Deshala Mendis
 * @version 1.0
 * @since 09.10.2020
 * ${base-url.context}
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDetailRepository repo;
    private UserDetailEntity users;

    @GetMapping("/getuser")
    public List<UserDetailEntity> getUser(){
        return repo.findAll();
    }


}
