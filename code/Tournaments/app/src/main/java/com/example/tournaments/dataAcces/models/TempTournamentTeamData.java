package com.example.tournaments.dataAcces.models;

public class TempTournamentTeamData {

    private int idTournamentTeam;
    private String name;

    public TempTournamentTeamData(int idTournamentTeam, String name) {
        this.idTournamentTeam = idTournamentTeam;
        this.name = name;
    }

    public TempTournamentTeamData() {}

    public int getIdTournamentTeam() {
        return idTournamentTeam;
    }

    public void setIdTournamentTeam(int idTournamentTeam) {
        this.idTournamentTeam = idTournamentTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TempTournamentTeamData{" +
                "idTournamentTeam=" + idTournamentTeam +
                ", name='" + name + '\'' +
                '}';
    }
}
