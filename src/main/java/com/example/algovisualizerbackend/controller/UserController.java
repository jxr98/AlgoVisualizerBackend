package com.example.algovisualizerbackend.controller;

import com.example.algovisualizerbackend.model.User;
import com.example.algovisualizerbackend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("users")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/signup")
    public User userSignup(User user) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        User newUser=objectMapper.readValue(user,User.class);
        if(user!=null){
            return userService.register(user.getName(),user.getPassword(),user.getEmail());
        }
        return null;
    }

    @PostMapping(value="/signin",produces = "application/json")
    public @ResponseBody User userSignin(User user){
        return userService.signin(user.getEmail(),user.getPassword());
    }
}
