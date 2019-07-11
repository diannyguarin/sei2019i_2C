package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.Administrator;

import java.util.ArrayList;

public class AdministratorRepository {
    Administrator administrator;

    public AdministratorRepository() {
        this.administrator = null;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public Administrator getAdminByUsername(String name){ //read
        ArrayList<String> res;
        try{
            String[] datos = new String[]{"SELECT * from "+ SQLHelper.usr +".Administrator WHERE username='"+name+"'"};
            res= new AsyncQuery("Administrator").execute(datos).get();

            String[] splint=new String[0];
            if (res.size()>0)
                splint=res.get(0).split(";");
            String sup="";
            for (int i=0;i<splint.length;i++){
                splint[i].trim();
            }
            if(splint!=null&&splint.length>0){
                this.administrator =new Administrator(Integer.valueOf(splint[0]),splint[1],splint[2]);
            }
        }catch(Exception ex)
        {
            Log.d("failure in query", ex.getMessage());
        }
        return this.administrator;
    }

    public boolean createAdmin(String name, String password){ //create
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into "+SQLHelper.usr+".Administrator(username,password) values ('"+name+"', '"+password+"')"};
            succes = new AsyncCUD().execute(datos).get();
            this.administrator =new Administrator(name,password);
        }catch(Exception ex)
        {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateAdmin(String username, String password){ //update
        boolean success=false;
        try{
            updateAdminUsername(username);
            updateAdminPassword(password);
            success=true;
        }catch(Exception ex){
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateAdminUsername(String username){ //update
        boolean succes=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(username != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Administrator set username='"+username+"'"};
                succes = new AsyncCUD().execute(datos).get();
                this.administrator.setUsername(username);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return succes;
    }

    public boolean updateAdminPassword(String password){ //update
        boolean succes=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(password != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Administrator set password='"+password+"'"};
                succes = new AsyncCUD().execute(datos).get();
                this.administrator.setPassword(password);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return succes;
    }
}
