package com.example.tournaments.BussinesLogic;

import android.util.Log;

import com.example.tournaments.dataAcces.repositories.UserRepository;

public class RegisterController {
    UserRepository user = new UserRepository();


    public boolean Register(String name, String username, String password){

        if(user.createUser(name,username,password)){
            Log.d("STATE","It works, info created: " + name + ", " + username + " , " + password);
            return true;
        }else{
            Log.d("STATE","It doesn't work, info created: " + name + ", " + username + " , " + password);
            return false;
        }
    }
}
