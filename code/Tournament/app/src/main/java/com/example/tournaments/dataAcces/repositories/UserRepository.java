package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.User;

import java.util.ArrayList;

public class UserRepository {
    User user;

    public UserRepository() {
        this.user = null;
    }

    public User getUser() {
        return user;
    }

    public User getUserByUsername(String username){ //read
        ArrayList<String> res;
        try{
            String[] datos = new String[]{"SELECT * from "+ SQLHelper.usr +".Users WHERE username='"+username+"'"};
            res= new AsyncQuery(0).execute(datos).get();

            String[] splint=new String[0];
            if (res.size()>0)
                splint=res.get(0).split(" ");
            String sup="";
            for (int i=0;i<splint.length;i++){
                splint[i].trim();
            }
            if(splint!=null&&splint.length>0){
                this.user =new User(splint[1],splint[2],splint[3]);
            }
        }catch(Exception ex)
        {
            Log.d("failure in query", ex.getMessage());
        }
        return this.user;
    }

    public boolean createUser(String name, String username, String password){ //create
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into "+SQLHelper.usr+".Users(name,username,password) values ('"+name+"', '"+username+"', '"+password+"')"};
            succes = new AsyncCUD().execute(datos).get();
            this.user =new User(name, username, password);
        }catch(Exception ex)
        {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateUser(String name, String username, String password){ //update
        boolean success=false;
        try{
            updateUserName(name);
            updateUserUsername(username);
            updateUserPassword(password);
            success=true;
        }catch(Exception ex){
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateUserName(String name){ //update
        boolean succes=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(name != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Users set name='"+name+"'"};
                succes = new AsyncCUD().execute(datos).get();
                this.user.setName(name);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return succes;
    }

    public boolean updateUserUsername(String username){ //update
        boolean succes=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(username != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Users set username='"+username+"'"};
                succes = new AsyncCUD().execute(datos).get();
                this.user.setUsername(username);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return succes;
    }

    public boolean updateUserPassword(String password){ //update
        boolean succes=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(password != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Users set password='"+password+"'"};
                succes = new AsyncCUD().execute(datos).get();
                this.user.setPassword(password);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return succes;
    }
}

