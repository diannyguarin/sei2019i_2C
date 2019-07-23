package com.example.tournaments.dataAcces.models;

public class TempUserTournamentData {
    private int idUserTournament;
    private String name;
    private int numberOfteams;

    public TempUserTournamentData(int idUserTournament, String name, int numberOfteams) {
        this.idUserTournament = idUserTournament;
        this.name = name;
        this.numberOfteams = numberOfteams;
    }

    public TempUserTournamentData() {}

    public int getIdUserTournament() {
        return idUserTournament;
    }

    public void setIdUserTournament(int idUserTournament) {
        this.idUserTournament = idUserTournament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfteams() {
        return numberOfteams;
    }

    public void setNumberOfteams(int numberOfteams) {
        this.numberOfteams = numberOfteams;
    }

    @Override
    public String toString() {
        return "TempUserTournamentData{" +
                "idUserTournament=" + idUserTournament +
                ", name='" + name + '\'' +
                ", numberOfteams=" + numberOfteams +
                '}';
    }
}
