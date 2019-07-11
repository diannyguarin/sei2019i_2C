package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.models.Administrator;
import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.AdministratorRepository;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class LoginController {

    private AdministratorRepository administratorRepository;
    private UserRepository userRepository;
    private User user = new User();
    private Administrator admin = new Administrator();



    public Administrator loginAdmin(String username, String password){
        administratorRepository = new AdministratorRepository();
        admin = administratorRepository.getAdminByUsername(username);
        if(admin==null){
            return admin;
        }else{
            String pass = admin.getPassword();
            if(pass.equals(password)){
                return admin;
            }else{
                return null;
            }
        }
    }


    public User loginUser(String username, String password){
        userRepository = new UserRepository();
        user = userRepository.getUserByUsername(username);
        if(user==null){
            return user;
        }else{
            String pass = user.getPassword();
            if(pass.equals(password)){
                return user;
            }else{
                return null;
            }
        }
    }
}
