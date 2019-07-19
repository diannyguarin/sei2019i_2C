package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.User_tournament_team;

import java.util.ArrayList;

public class User_tournament_teamRepository {
    User_tournament_team user_tournament_team;

    public User_tournament_teamRepository() {
        this.user_tournament_team = null;
    }

    public User_tournament_team getUser_tournament_team() {
        return user_tournament_team;
    }

    public ArrayList<User_tournament_team> getAllUser_tournament_teams() { //read
        ArrayList<String> res;
        ArrayList<User_tournament_team> sol = new ArrayList<>();
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Users_tournaments_teams"};
            res = new AsyncQuery("Users_tournaments_teams").execute(datos).get();

            String[] splint = new String[res.size() * 6];

            for (int j = 0; j < res.size(); j++) {
                splint = res.get(j).split(";");
                if (splint != null && splint.length > 0) {
                    sol.add(new User_tournament_team(Integer.valueOf(splint[0]), Integer.valueOf(splint[1]), Integer.valueOf(splint[2])));
                }
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return sol;
    }

    public ArrayList<User_tournament_team> getUser_tournament_teamsByUser_tournament(int user_tournamentId) { //read
        ArrayList<String> res;
        ArrayList<User_tournament_team> sol = new ArrayList<>();
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Users_tournaments_teams where user_tournament=" + user_tournamentId};
            res = new AsyncQuery("Users_tournaments_teams").execute(datos).get();

            String[] splint = new String[res.size() * 6];

            for (int j = 0; j < res.size(); j++) {
                splint = res.get(j).split(";");
                if (splint != null && splint.length > 0) {
                    sol.add(new User_tournament_team(Integer.valueOf(splint[0]), Integer.valueOf(splint[1]), Integer.valueOf(splint[2])));
                }
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return sol;
    }

    public User_tournament_team getUser_tournament_teamById(int id) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Users_tournaments_teams WHERE id=" + id};
            res = new AsyncQuery("Users_tournaments_teams").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(";");
            String sup = "";
            for (int i = 0; i < splint.length; i++) {
                splint[i].trim();
            }
            if (splint != null && splint.length > 0) {
                this.user_tournament_team = new User_tournament_team(Integer.valueOf(splint[0]), Integer.valueOf(splint[1]), Integer.valueOf(splint[2]));
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.user_tournament_team;
    }

    public boolean createUser_tournament_team(int team, int user_tournament) { //create
        boolean succes = false;
        try {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into " + SQLHelper.usr + ".Users_tournaments_teams(team,user_tournament) values (" + team + "," + user_tournament + ")"};
            succes = new AsyncCUD().execute(datos).get();
            this.user_tournament_team = new User_tournament_team(team, user_tournament);
        } catch (Exception ex) {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateUser_tournament_team(int id, int team, int user_tournament) { //update
        boolean success = false;
        try {
            updateUser_tournament_teamTeam(team, id);
            updateUser_tournament_teamUser_tournament(user_tournament, id);
            success = true;
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }


    public boolean updateUser_tournament_teamTeam(int team, int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (team > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Users_tournaments_teams set team=" + team + " WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
                this.user_tournament_team.setTeam(team);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateUser_tournament_teamUser_tournament(int user_tournament, int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (user_tournament > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Users_tournaments_teams set user_tournament=" + user_tournament + " WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
                this.user_tournament_team.setUser_tournament(user_tournament);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }


    public boolean deleteUser_tournament_teamById(int id) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (id > 0) {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Users_tournaments_teams WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }
}
