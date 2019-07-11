package com.example.tournaments.dataAcces.models;

public class Tournament {
    private int id_torneo;
    private String name;
    private int admin;
    private int sport;
    private int type;
    private int numberOfTeams;

    public Tournament(int id_torneo, String name, int admin, int sport, int type, int numberOfTeams) {
        this.id_torneo = id_torneo;
        this.name = name;
        this.admin = admin;
        this.sport = sport;
        this.type = type;
        this.numberOfTeams = numberOfTeams;
    }

    public Tournament(String name, int admin, int sport, int type, int numberOfTeams) {
        this.name = name;
        this.admin = admin;
        this.sport = sport;
        this.type = type;
        this.numberOfTeams = numberOfTeams;
    }

    public int getId_torneo() {
        return id_torneo;
    }

    public void setId_torneo(int id_torneo) {
        this.id_torneo = id_torneo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id_torneo=" + id_torneo +
                ", name='" + name + '\'' +
                ", admin=" + admin +
                ", sport=" + sport +
                ", type=" + type +
                ", numberOfTeams=" + numberOfTeams +
                '}';
    }
}
