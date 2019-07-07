package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class SignupController {
    private UserRepository userRepository;
    private User user = new User();

    public String signUp(String name, String username, String password){
        String message;
        userRepository = new UserRepository();
        user = new User();
        user = userRepository.getUserByUsername(username);
        if(user!=null){
            message = "That username is already in use.";
            return message;
        }else{
            userRepository.createUser(name, username, password);
            message = "User created.";
            return message;
        }
    }
}
