package com.example.algovisualizerbackend.service;

import com.example.algovisualizerbackend.model.User;
import com.example.algovisualizerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(String name, String password, String email){
        userRepository.createByNameAndPasswordAndEmail(name, password, email);
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User signin(String email,String password){
        return userRepository.findByEmailAndPassword(email, password);
    }
}
