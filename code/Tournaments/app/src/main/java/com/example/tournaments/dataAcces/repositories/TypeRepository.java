package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.Tournament_Type;

import java.util.ArrayList;

public class TypeRepository {
    Tournament_Type Tournament_type;

    public TypeRepository() {
        this.Tournament_type = null;
    }

    public ArrayList<Tournament_Type> getAllTournaments_Types() { //read
        ArrayList<String> res;
        ArrayList<Tournament_Type> sol = new ArrayList<>();
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Tournament_types"};
            res = new AsyncQuery("Tournament_types").execute(datos).get();

            String[] splint = new String[res.size() * 6];

            for (int j = 0; j < res.size(); j++) {
                splint = res.get(j).split(";");
                if (splint != null && splint.length > 0) {
                    sol.add(new Tournament_Type(Integer.valueOf(splint[0]), splint[1]));
                }
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return sol;
    }

    public Tournament_Type getTournament_Type() {
        return Tournament_type;
    }

    public Tournament_Type getTournament_TypeByName(String name){ //read
        ArrayList<String> res;
        try{
            String[] datos = new String[]{"SELECT * from "+ SQLHelper.usr +".Tournament_types WHERE name='"+name+"'"};
            res= new AsyncQuery(" Tournament_types").execute(datos).get();

            String[] splint=new String[0];
            if (res.size()>0)
                splint=res.get(0).split(";");
            String sup="";
            for (int i=0;i<splint.length;i++){
                splint[i].trim();
            }
            if(splint!=null&&splint.length>0){
                this.Tournament_type =new Tournament_Type(Integer.valueOf(splint[0]),splint[1]);
            }
        }catch(Exception ex)
        {
            Log.d("failure in query", ex.getMessage());
        }
        return this.Tournament_type;
    }

    public Tournament_Type getTournament_TypeById(int id) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Tournament_types WHERE id=" + id};
            res = new AsyncQuery(" Tournament_types").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(";");
            String sup = "";
            for (int i = 0; i < splint.length; i++) {
                splint[i].trim();
            }
            if (splint != null && splint.length > 0) {
                this.Tournament_type = new Tournament_Type(Integer.valueOf(splint[0]), splint[1]);
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.Tournament_type;
    }

    public boolean createTournament_Type(String name){ //create
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into " + SQLHelper.usr + ".Tournament_types(name) values ('" + name + "')"};
            succes = new AsyncCUD().execute(datos).get();
            this.Tournament_type =new Tournament_Type(name);
        }catch(Exception ex)
        {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateTournament_Type(String currentName,String name){ //update
        boolean success=false;
        try{
            updateTournament_TypeName(name, currentName);
            success=true;
        }catch(Exception ex){
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTournament_TypeName(String name, String currentName){ //update
        boolean success=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(name != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Tournament_types set name='"+name+"' WHERE name='"+currentName+"'"};
                success = new AsyncCUD().execute(datos).get();

                this.Tournament_type.setTypename(name);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean deleteTournament_TypeByName(String name) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (name != "") {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Tournament_types WHERE name='" + name + "'"};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }

    public boolean deleteTournament_TypeById(int id) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (id > 0) {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Tournament_types WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }

}
