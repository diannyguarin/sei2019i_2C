package com.example.tournaments.businessLogic.Controllers;

import android.os.Bundle;

import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class UpdateController {
    private UserRepository userRepository;
    private User user;

    public void updateUser(String currentUsername, String name, String username, String password){
        userRepository = new UserRepository();
        userRepository.updateUser(currentUsername, name, username, password);
    }
}

/* public void updateUser(String currentUsername, String name, String username, String password){
        userRepository = new UserRepository();
        userRepository.updateUser(currentUsername, name, username, password);
    }*/
