package com.example.tournaments.dataAcces.models;

public class Team {
    private int id;
    private String name;
    private int user;

    public Team(int id, String name, int user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Team(String name, int user) {
        this.name = name;
        this.user = user;
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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
