package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).get();

        return user.getName();
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }


    @GetMapping("/user/all")
    public List<User> insertUser() {
        List list = userRepository.findAll();

        return list;
    }
}