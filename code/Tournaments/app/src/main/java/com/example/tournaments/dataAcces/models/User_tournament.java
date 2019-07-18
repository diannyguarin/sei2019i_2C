package com.example.tournaments.dataAcces.models;

public class User_tournament {
    private int id;
    private String name;
    private int user;
    private int tournament;

    public User_tournament(int id, String name, int user, int tournament) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.tournament = tournament;
    }

    public User_tournament(String name, int user, int tournament) {
        this.name = name;
        this.user = user;
        this.tournament = tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", user=" + user +
                ", tournament=" + tournament +
                '}';
    }
}
