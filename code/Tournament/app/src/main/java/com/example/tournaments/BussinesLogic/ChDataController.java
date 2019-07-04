package com.example.tournaments.BussinesLogic;

import android.util.Log;

import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class ChDataController {
    UserRepository user = new UserRepository();


    public boolean ChData(String actualName,String name, String username, String password){
        user.getUserByUsername(actualName);
        if(user.updateUser(name,username,password)){
            Log.d("STATE","It works, info created: " + name + ", " + username + " , " + password);
            return true;
        }else{
            Log.d("STATE","It doesn't work, info created: " + name + ", " + username + " , " + password);
            return false;
        }
    }
}
