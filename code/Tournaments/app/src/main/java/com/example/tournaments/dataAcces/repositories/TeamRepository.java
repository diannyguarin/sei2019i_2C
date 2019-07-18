package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.Team;

import java.util.ArrayList;

public class TeamRepository {
    private Team team;

    public TeamRepository() {
        this.team = null;
    }

    public Team getUser_tournament() {
        return team;
    }

    public ArrayList<Team> getAllTeams() { //read
        ArrayList<String> res;
        ArrayList<Team> sol = new ArrayList<>();
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Teams"};
            res = new AsyncQuery("Teams").execute(datos).get();

            String[] splint;

            for (int j = 0; j < res.size(); j++) {
                splint = res.get(j).split(";");
                if (splint.length > 0) {
                    sol.add(new Team(Integer.valueOf(splint[0]), splint[1], Integer.valueOf(splint[2])));
                }
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return sol;
    }

    public Team getTeamByName(String name) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Teams WHERE name='" + name + "'"};
            res = new AsyncQuery("Teams").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(";");
            String sup = "";
            for (String s : splint) {
                s.trim();
            }
            if (splint.length > 0) {
                this.team = new Team(Integer.valueOf(splint[0]), splint[1], Integer.valueOf(splint[2]));
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.team;
    }

    public Team getTeamById(int id) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Teams WHERE id=" + id};
            res = new AsyncQuery("Teams").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(";");
            String sup = "";
            for (String s : splint) {
                s.trim();
            }
            if (splint.length > 0) {
                this.team = new Team(Integer.valueOf(splint[0]), splint[1], Integer.valueOf(splint[2]));
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.team;
    }

    public boolean createTeam(String name, int user) { //create
        boolean succes = false;
        try {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into " + SQLHelper.usr + ".Teams(name,user) values ('" + name + "'," + user + ")"};
            succes = new AsyncCUD().execute(datos).get();
            this.team = new Team(name, user);
        } catch (Exception ex) {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateTeam(String currentName, String name, int user) { //update
        boolean success = false;
        try {
            updateTeamName(name, currentName);
            updateTeamUser(user, currentName);
            success = true;
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTeamName(String name, String currentName) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (name != "") {
                datos = new String[]{"update " + SQLHelper.usr + ".Teams set name='" + name + "' WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.team.setName(name);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateTeamUser(int user, String currentName) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (user > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Teams set user='" + user + "' WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.team.setUser(user);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }


    public boolean deleteTeamByName(String name) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (name != "") {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Teams WHERE name='" + name + "'"};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }

    public boolean deleteTeamById(int id) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (id > 0) {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Teams WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }
}
