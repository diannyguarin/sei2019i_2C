package com.example.tournaments.BussinesLogic;

import android.os.Bundle;

import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class ChDataController {
    private UserRepository userRepository;
    private User user;

    public void updateUser(String currentUsername, String name, String username, String password){
        userRepository = new UserRepository();
        userRepository.updateUser(currentUsername, name, username, password);
    }
}
