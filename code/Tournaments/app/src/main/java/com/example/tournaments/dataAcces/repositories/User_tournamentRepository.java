package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.User_tournament;

import java.util.ArrayList;

public class User_tournamentRepository {
    User_tournament user_tournament;

    public User_tournamentRepository() {
        this.user_tournament = null;
    }

    public User_tournament getUser_tournament() {
        return user_tournament;
    }

    public ArrayList<User_tournament> getAllUser_tournaments() { //read
        ArrayList<String> res;
        ArrayList<User_tournament> sol = new ArrayList<>();
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Users_tournaments"};
            res = new AsyncQuery("Users_tournaments").execute(datos).get();

            String[] splint = new String[res.size() * 6];

            for (int j = 0; j < res.size(); j++) {
                splint = res.get(j).split(";");
                if (splint != null && splint.length > 0) {
                    sol.add(new User_tournament(Integer.valueOf(splint[0]), splint[1], Integer.valueOf(splint[2]), Integer.valueOf(splint[3])));
                }
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return sol;
    }

    public User_tournament getUser_tournamentByName(String name) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Users_tournaments WHERE name='" + name + "'"};
            res = new AsyncQuery("Users_tournaments").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(";");
            String sup = "";
            for (int i = 0; i < splint.length; i++) {
                splint[i].trim();
            }
            if (splint != null && splint.length > 0) {
                this.user_tournament = new User_tournament(Integer.valueOf(splint[0]), splint[1], Integer.valueOf(splint[2]), Integer.valueOf(splint[3]));
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.user_tournament;
    }

    public User_tournament getUser_tournamentById(int id) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Users_tournaments WHERE id=" + id};
            res = new AsyncQuery("Users_tournaments").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(";");
            String sup = "";
            for (int i = 0; i < splint.length; i++) {
                splint[i].trim();
            }
            if (splint != null && splint.length > 0) {
                this.user_tournament = new User_tournament(Integer.valueOf(splint[0]), splint[1], Integer.valueOf(splint[2]), Integer.valueOf(splint[3]));
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.user_tournament;
    }

    public boolean createUser_tournament(String name, int user, int tournament) { //create
        boolean succes = false;
        try {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into " + SQLHelper.usr + ".Users_tournaments(name,user,tournament) values ('" + name + "'," + user + "," + tournament + ")"};
            succes = new AsyncCUD().execute(datos).get();
            this.user_tournament = new User_tournament(name, user, tournament);
        } catch (Exception ex) {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateUser_tournament(String currentName, String name, int user, int tournament) { //update
        boolean success = false;
        try {
            updateUser_tournamentName(name, currentName);
            updateUser_tournamentUser(user, currentName);
            updateUser_tournamentTournament(tournament, currentName);
            success = true;
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateUser_tournamentName(String name, String currentName) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (name != "") {
                datos = new String[]{"update " + SQLHelper.usr + ".Users_tournaments set name='" + name + "' WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.user_tournament.setName(name);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateUser_tournamentUser(int user, String currentName) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (user > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Users_tournaments set user=" + user + " WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.user_tournament.setUser(user);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateUser_tournamentTournament(int tournament, String currentName) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (tournament > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Users_tournaments set tournament=" + tournament + " WHERE name='" + currentName + "'"};
                success = new AsyncCUD().execute(datos).get();
                this.user_tournament.setTournament(tournament);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean deleteUser_tournamentByName(String name) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (name != "") {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Users_tournaments WHERE name='" + name + "'"};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }

    public boolean deleteUser_tournamentById(int id) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (id > 0) {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Users_tournaments WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }
}
