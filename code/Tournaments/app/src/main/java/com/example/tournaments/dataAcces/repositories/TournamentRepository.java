package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.Tournament;

import java.util.ArrayList;

public class TournamentRepository {
    Tournament tour;

    public TournamentRepository() {
        this.tour = null;
    }

    public Tournament getTournament() {
        return tour;
    }
    
    public ArrayList<Tournament> getAllTournaments(){ //read
        ArrayList<String> res;
        ArrayList<Tournament> sol = new ArrayList<>();
        try{
            String[] datos = new String[]{"SELECT * from "+ SQLHelper.usr +".Tournaments"};
            res= new AsyncQuery("Tournaments").execute(datos).get();

            String[] splint=new String[res.size()*6];

            for (int j = 0; j<res.size(); j++){
                splint=res.get(j).split(";");
                if(splint!=null&&splint.length>0){
                    sol.add(new Tournament(Integer.valueOf(splint[0]),splint[1],Integer.valueOf(splint[2]),Integer.valueOf(splint[3]),Integer.valueOf(splint[4]),Integer.valueOf(splint[5])));
                }
            }
        }catch(Exception ex)
        {
            Log.d("failure in query", ex.getMessage());
        }
        return sol;
    }

    public Tournament getTournamentByName(String name){ //read
        ArrayList<String> res;
        try{
            String[] datos = new String[]{"SELECT * from "+ SQLHelper.usr +".Tournaments WHERE name='"+name+"'"};
            res= new AsyncQuery("Tournaments").execute(datos).get();

            String[] splint=new String[0];
            if (res.size()>0)
                splint=res.get(0).split(" ");
            String sup="";
            for (int i=0;i<splint.length;i++){
                splint[i].trim();
            }
            if(splint!=null&&splint.length>0){
                this.tour =new Tournament(Integer.valueOf(splint[0]),splint[1],Integer.valueOf(splint[2]),Integer.valueOf(splint[3]),Integer.valueOf(splint[4]),Integer.valueOf(splint[5]));
            }
        }catch(Exception ex)
        {
            Log.d("failure in query", ex.getMessage());
        }
        return this.tour;
    }

    public Tournament getTournamentById(int id) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Tournaments WHERE id=" + id};
            res = new AsyncQuery("Tournaments").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(" ");
            String sup = "";
            for (int i = 0; i < splint.length; i++) {
                splint[i].trim();
            }
            if (splint != null && splint.length > 0) {
                this.tour = new Tournament(Integer.valueOf(splint[0]), splint[1], Integer.valueOf(splint[2]), Integer.valueOf(splint[3]), Integer.valueOf(splint[4]), Integer.valueOf(splint[5]));
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.tour;
    }

    public boolean createTournament(String name,int sport, int type, int numTeams){ //create
        boolean succes=false;
        try
        {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into "+SQLHelper.usr+".Tournaments(name,admin,sport,type,numberOfTeams) values ('"+name+"', 1, "+sport+", "+type+", "+numTeams+")"};
            succes = new AsyncCUD().execute(datos).get();
                this.tour =new Tournament(name, sport, type, numTeams);
        }catch(Exception ex)
        {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateTournament(String currentName,String name, int admin, int sport, int type, int numTeams){ //update
        boolean success=false;
        try{
            updateTournamentName(name, currentName);
            updateTournamentSport(sport, currentName);
            updateTournamentType(type, currentName);
            updateTournamentNumTeams(numTeams, currentName);
            success=true;
        }catch(Exception ex){
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTournamentName(String name, String currentName){ //update
        boolean success=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(name != ""){
                datos = new String[]{"update "+SQLHelper.usr+".Tournaments set name='"+name+"' WHERE name='"+currentName+"'"};
                success = new AsyncCUD().execute(datos).get();
                this.tour.setName(name);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTournamentAdmin(int admin, String currentName){ //update
        boolean success=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(admin > 0){
                datos = new String[]{"update " + SQLHelper.usr + ".Tournaments set admin='" + admin + "' WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.tour.setAdmin(admin);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTournamentSport(int sport, String currentName){ //update
        boolean success=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(sport > 0){
                datos = new String[]{"update " + SQLHelper.usr + ".Tournaments set sport='" + sport + "' WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.tour.setSport(sport);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTournamentType(int type, String currentName){ //update
        boolean success=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(type > 0){
                datos = new String[]{"update " + SQLHelper.usr + ".Tournaments set type='" + type + "' WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.tour.setType(type);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTournamentNumTeams(int numTeams, String currentName){ //update
        boolean success=false;
        try
        {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if(numTeams > 1){
                datos = new String[]{"update " + SQLHelper.usr + ".Tournaments set numberOfTeams='" + numTeams + "' WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.tour.setNumberOfTeams(numTeams);
            }
        }catch(Exception ex)
        {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean deleteTournamentbyName(String name) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (name != "") {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Tournaments WHERE name='" + name + "'"};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }

    public boolean deleteTournamentById(int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (id > 0) {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Tournaments WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }
}

