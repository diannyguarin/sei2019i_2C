package com.example.tournaments.dataAcces.repositories;

import android.util.Log;

import com.example.tournaments.dataAcces.databases.AsyncCUD;
import com.example.tournaments.dataAcces.databases.AsyncQuery;
import com.example.tournaments.dataAcces.databases.SQLHelper;
import com.example.tournaments.dataAcces.models.Matchup;

import java.util.ArrayList;

public class MatchupRepository {
    Matchup matchup;

    public MatchupRepository() {
        this.matchup = null;
    }

    public Matchup getMatchup() {
        return matchup;
    }

    public ArrayList<Matchup> getAllMatchups() { //read
        ArrayList<String> res;
        ArrayList<Matchup> sol = new ArrayList<>();
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Matchups"};
            res = new AsyncQuery("Matchups").execute(datos).get();

            String[] splint = new String[res.size() * 6];

            for (int j = 0; j < res.size(); j++) {
                splint = res.get(j).split(";");
                if (splint != null && splint.length > 0) {
                    sol.add(new Matchup(Integer.valueOf(splint[0]), Integer.valueOf(splint[1]), Integer.valueOf(splint[2]), splint[3], Integer.valueOf(splint[4]), splint[5]));
                }
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return sol;
    }


    public Matchup getMatchupById(int id) { //read
        ArrayList<String> res;
        try {
            String[] datos = new String[]{"SELECT * from " + SQLHelper.usr + ".Matchups WHERE id=" + id};
            res = new AsyncQuery("Matchups").execute(datos).get();

            String[] splint = new String[0];
            if (res.size() > 0)
                splint = res.get(0).split(";");
            String sup = "";
            for (int i = 0; i < splint.length; i++) {
                splint[i].trim();
            }
            if (splint != null && splint.length > 0) {
                this.matchup = new Matchup(Integer.valueOf(splint[0]), Integer.valueOf(splint[1]), Integer.valueOf(splint[2]), splint[3], Integer.valueOf(splint[4]), splint[5]);
            }
        } catch (Exception ex) {
            Log.d("failure in query", ex.getMessage());
        }
        return this.matchup;
    }

    public boolean createMatchup(int localTeam, int visitorTeam, String phase, int bracket, String winner) { //create
        boolean succes = false;
        try {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{"insert into " + SQLHelper.usr + ".Matchups(localTeam,visitorTeam,phase,bracket,winner) values (" + localTeam + "," + visitorTeam + ",'" + phase + "'," + bracket + ",'" + winner + "')"};
            succes = new AsyncCUD().execute(datos).get();
            this.matchup = new Matchup(localTeam, visitorTeam, phase, bracket, winner);
        } catch (Exception ex) {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean createMatchupsImproved(ArrayList<Matchup> matchupArrayList) { //create
        boolean succes = false;
        try {
            Class.forName(SQLHelper.driver).newInstance();
            String[] datos = new String[]{};

            switch (matchupArrayList.size()) {
                case 2:
                    datos = new String[]{"insert into Matchups(localTeam, visitorTeam, phase, bracket) VALUES("+matchupArrayList.get(0).getLocalTeam()+", "+matchupArrayList.get(0).getVisitorTeam()+", '"+matchupArrayList.get(0).getPhase()+"', "+matchupArrayList.get(0).getBracket()+"), ("+matchupArrayList.get(1).getLocalTeam()+", "+matchupArrayList.get(1).getVisitorTeam()+", '"+matchupArrayList.get(1).getPhase()+"', "+matchupArrayList.get(1).getBracket()+")"};
                    succes = new AsyncCUD().execute(datos).get();
                    break;
                case 4:
                    datos = new String[]{"insert into Matchups(localTeam, visitorTeam, phase, bracket) VALUES("+matchupArrayList.get(0).getLocalTeam()+", "+matchupArrayList.get(0).getVisitorTeam()+", '"+matchupArrayList.get(0).getPhase()+"', "+matchupArrayList.get(0).getBracket()+"), ("+matchupArrayList.get(1).getLocalTeam()+", "+matchupArrayList.get(1).getVisitorTeam()+", '"+matchupArrayList.get(1).getPhase()+"', "+matchupArrayList.get(1).getBracket()+"), ("+matchupArrayList.get(2).getLocalTeam()+", "+matchupArrayList.get(2).getVisitorTeam()+", '"+matchupArrayList.get(2).getPhase()+"', "+matchupArrayList.get(2).getBracket()+"), ("+matchupArrayList.get(3).getLocalTeam()+", "+matchupArrayList.get(3).getVisitorTeam()+", '"+matchupArrayList.get(3).getPhase()+"', "+matchupArrayList.get(3).getBracket()+")"};
                    succes = new AsyncCUD().execute(datos).get();
                    break;
                case 8:
                    datos = new String[]{"insert into Matchups(localTeam, visitorTeam, phase, bracket) VALUES("+matchupArrayList.get(0).getLocalTeam()+", "+matchupArrayList.get(0).getVisitorTeam()+", '"+matchupArrayList.get(0).getPhase()+"', "+matchupArrayList.get(0).getBracket()+"), ("+matchupArrayList.get(1).getLocalTeam()+", "+matchupArrayList.get(1).getVisitorTeam()+", '"+matchupArrayList.get(1).getPhase()+"', "+matchupArrayList.get(1).getBracket()+"), ("+matchupArrayList.get(2).getLocalTeam()+", "+matchupArrayList.get(2).getVisitorTeam()+", '"+matchupArrayList.get(2).getPhase()+"', "+matchupArrayList.get(2).getBracket()+"), ("+matchupArrayList.get(3).getLocalTeam()+", "+matchupArrayList.get(3).getVisitorTeam()+", '"+matchupArrayList.get(3).getPhase()+"', "+matchupArrayList.get(3).getBracket()+"), ("+matchupArrayList.get(4).getLocalTeam()+", "+matchupArrayList.get(4).getVisitorTeam()+", '"+matchupArrayList.get(4).getPhase()+"', "+matchupArrayList.get(4).getBracket()+"), ("+matchupArrayList.get(5).getLocalTeam()+", "+matchupArrayList.get(5).getVisitorTeam()+", '"+matchupArrayList.get(5).getPhase()+"', "+matchupArrayList.get(5).getBracket()+"), ("+matchupArrayList.get(6).getLocalTeam()+", "+matchupArrayList.get(6).getVisitorTeam()+", '"+matchupArrayList.get(6).getPhase()+"', "+matchupArrayList.get(6).getBracket()+"), ("+matchupArrayList.get(7).getLocalTeam()+", "+matchupArrayList.get(7).getVisitorTeam()+", '"+matchupArrayList.get(7).getPhase()+"', "+matchupArrayList.get(7).getBracket()+")"};
                    succes = new AsyncCUD().execute(datos).get();
                    break;
//                case 16:
//                    datos = new String[]{"insert into Matchups(localTeam, visitorTeam, phase, bracket) VALUES("+matchupArrayList.get(0).getLocalTeam()+", "+matchupArrayList.get(0).getVisitorTeam()+", "+matchupArrayList.get(0).getPhase()+", "+matchupArrayList.get(0).getBracket()+"), ("+matchupArrayList.get(1).getLocalTeam()+", "+matchupArrayList.get(1).getVisitorTeam()+", "+matchupArrayList.get(1).getPhase()+", "+matchupArrayList.get(1).getBracket()+"), ("+matchupArrayList.get(2).getLocalTeam()+", "+matchupArrayList.get(2).getVisitorTeam()+", "+matchupArrayList.get(2).getPhase()+", "+matchupArrayList.get(2).getBracket()+"), ("+matchupArrayList.get(3).getLocalTeam()+", "+matchupArrayList.get(3).getVisitorTeam()+", "+matchupArrayList.get(3).getPhase()+", "+matchupArrayList.get(3).getBracket()+"), ("+matchupArrayList.get(4).getLocalTeam()+", "+matchupArrayList.get(4).getVisitorTeam()+", "+matchupArrayList.get(4).getPhase()+", "+matchupArrayList.get(4).getBracket()+"), ("+matchupArrayList.get(5).getLocalTeam()+", "+matchupArrayList.get(5).getVisitorTeam()+", "+matchupArrayList.get(5).getPhase()+", "+matchupArrayList.get(5).getBracket()+"), ("+matchupArrayList.get(6).getLocalTeam()+", "+matchupArrayList.get(6).getVisitorTeam()+", "+matchupArrayList.get(6).getPhase()+", "+matchupArrayList.get(6).getBracket()+"), ("+matchupArrayList.get(7).getLocalTeam()+", "+matchupArrayList.get(7).getVisitorTeam()+", "+matchupArrayList.get(7).getPhase()+", "+matchupArrayList.get(7).getBracket()+"), ("+matchupArrayList.get(8).getLocalTeam()+", "+matchupArrayList.get(8).getVisitorTeam()+", "+matchupArrayList.get(8).getPhase()+", "+matchupArrayList.get(8).getBracket()+"), ("+matchupArrayList.get(9).getLocalTeam()+", "+matchupArrayList.get(9).getVisitorTeam()+", "+matchupArrayList.get(9).getPhase()+", "+matchupArrayList.get(9).getBracket()+"), ("+matchupArrayList.get(10).getLocalTeam()+", "+matchupArrayList.get(10).getVisitorTeam()+", "+matchupArrayList.get(10).getPhase()+", "+matchupArrayList.get(10).getBracket()+"), ("+matchupArrayList.get(11).getLocalTeam()+", "+matchupArrayList.get(11).getVisitorTeam()+", "+matchupArrayList.get(11).getPhase()+", "+matchupArrayList.get(11).getBracket()+"), ("+matchupArrayList.get(12).getLocalTeam()+", "+matchupArrayList.get(12).getVisitorTeam()+", "+matchupArrayList.get(12).getPhase()+", "+matchupArrayList.get(12).getBracket()+"), ("+matchupArrayList.get(13).getLocalTeam()+", "+matchupArrayList.get(13).getVisitorTeam()+", "+matchupArrayList.get(13).getPhase()+", "+matchupArrayList.get(13).getBracket()+"), ("+matchupArrayList.get(14).getLocalTeam()+", "+matchupArrayList.get(14).getVisitorTeam()+", "+matchupArrayList.get(14).getPhase()+", "+matchupArrayList.get(14).getBracket()+"), ("+matchupArrayList.get(15).getLocalTeam()+", "+matchupArrayList.get(15).getVisitorTeam()+", "+matchupArrayList.get(15).getPhase()+", "+matchupArrayList.get(15).getBracket()+")"};
//                    succes = new AsyncCUD().execute(datos).get();
//                    break;
            }
        } catch (Exception ex) {
            Log.d("failure in insert", ex.getMessage());
        }
        return succes;
    }

    public boolean updateMatchup(int id, int localTeam, int visitorTeam, String phase, int bracket, String winner) { //update
        boolean success = false;
        try {
            updateMatchupLocalTeam(localTeam, id);
            updateMatchupVisitorTeam(visitorTeam, id);
            updateMatchupPhase(phase, id);
            updateMatchupBracket(bracket, id);
            updateMatchupWinner(winner, id);
            success = true;
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateMatchupPhase(String phase, int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (phase != "") {
                datos = new String[]{"update " + SQLHelper.usr + ".Matchups set phase='" + phase + "' WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
                this.matchup.setPhase(phase);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateMatchupWinner(String winner, int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (winner != "") {
                datos = new String[]{"update " + SQLHelper.usr + ".Matchups set winner='" + winner + "' WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
                this.matchup.setWinner(winner);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateMatchupLocalTeam(int localTeam, int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (localTeam > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Matchups set localTeam='" + localTeam + "' WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
                this.matchup.setLocalTeam(localTeam);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateMatchupVisitorTeam(int visitorTeam, int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (visitorTeam > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Matchups set visitorTeam='" + visitorTeam + "' WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
                this.matchup.setVisitorTeam(visitorTeam);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean updateMatchupBracket(int bracket, int id) { //update
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (bracket > 0) {
                datos = new String[]{"update " + SQLHelper.usr + ".Matchups set bracket='" + bracket + "' WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
                this.matchup.setBracket(bracket);
            }
        } catch (Exception ex) {
            Log.d("failure in update", ex.getMessage());
        }
        return success;
    }

    public boolean deleteMatchupById(int id) { //delete
        boolean success = false;
        try {
            String[] datos = new String[]{};
            Class.forName(SQLHelper.driver).newInstance();
            if (id > 0) {
                datos = new String[]{"delete from " + SQLHelper.usr + ".Matchups WHERE id=" + id};
                success = new AsyncCUD().execute(datos).get();
            }
        } catch (Exception ex) {
            Log.d("failure in delete", ex.getMessage());
        }
        return success;
    }
}
