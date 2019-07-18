package com.example.tournaments.dataAcces.models;

public class User_tournament_team {
    private int id;
    private int team;
    private int user_tournament;

    public User_tournament_team(int id, int team, int user_tournament) {
        this.id = id;
        this.team = team;
        this.user_tournament = user_tournament;
    }

    public User_tournament_team(int team, int user_tournament) {
        this.team = team;
        this.user_tournament = user_tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getUser_tournament() {
        return user_tournament;
    }

    public void setUser_tournament(int user_tournament) {
        this.user_tournament = user_tournament;
    }

    @Override
    public String toString() {
        return "User_tournament_team{" +
                "id=" + id +
                ", team=" + team +
                ", user_tournament=" + user_tournament +
                '}';
    }
}
