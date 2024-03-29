package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.Sport;


import java.util.ArrayList;

public class SportRepository {
    Sport sport;

    public SportRepository() {
        this.sport = null;
    }

    public Sport getSport() {
        return sport;
    }

    public Sport getSportByName(String name){ //read
        ArrayList<String> res;
        try{
            String[] datos = new String[]{"SELECT * from "+ SQLHelper.usr +".Sports WHERE name='"+name+"'"};
            res= new AsyncQuery("Sports").execute(datos).get();

            String[] splint=new String[0];
            if (res.size()>0)
                splint=res.get(0).split(";");
            String sup="";
            for (int i=0;i<splint.length;i++){
                splint[i].trim();
            }
            if(splint!=null&&splint.length>0){
                this.sport =new Sport(Integer.valueOf(splint[0]),splint[1]);
            }
        }catch(Exception ex)
        {
            Log.d("failure in query", ex.getMessage());
        }
        return this.sport;
    }

    public boolean createSport(String name){ //create
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into "+SQLHelper.usr+".Sports(name) values ('"+name+")"};
            succes = new AsyncCUD().execute(datos).get();
            this.sport =new Sport(name);
        }catch(Exception ex)
        {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateSport(String currentName,String name){ //update
        boolean success=false;
        try{
            updateSportName(name, currentName);
            success=true;
        }catch(Exception ex){
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateSportName(String name, String currentName){ //update
        boolean success=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(name != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Sports set name='"+name+"' WHERE name='"+currentName+"'"};
                success = new AsyncCUD().execute(datos).get();
                this.sport.setsportname(name);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

}
