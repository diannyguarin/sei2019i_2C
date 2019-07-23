package com.example.tournaments.dataAcces.models;

public class User_tournament {
    private int id;
    private int user;
    private int tournament;

    public User_tournament(int id, int user, int tournament) {
        this.id = id;
        this.user = user;
        this.tournament = tournament;
    }

    public User_tournament(int user, int tournament) {
        this.user = user;
        this.tournament = tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTournament() {
        return tournament;
    }

    public void setTournament(int tournament) {
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return "User_tournament{" +
                "id=" + id +
                ", user=" + user +
                ", tournament=" + tournament +
                '}';
    }
}
