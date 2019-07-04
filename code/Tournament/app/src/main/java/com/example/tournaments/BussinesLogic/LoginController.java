package com.example.tournaments.BussinesLogic;

import android.util.Log;

import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class LoginController {
    UserRepository user = new UserRepository();


    public boolean Login(String username, String Password){
        User temp = user.getUserByUsername(username);
        String pass;

        pass = temp.getPassword();

        if(Password.equals(pass) ){
            Log.d("STATE","It works");
            return true;
        }else{
            Log.d("STATE","It doesn't work");
            return false;
        }
    }
}