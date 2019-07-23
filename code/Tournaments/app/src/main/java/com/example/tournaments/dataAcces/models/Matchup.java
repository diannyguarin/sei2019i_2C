package com.example.tournaments.dataAcces.models;

public class Matchup {
    private int id;
    private int localTeam;
    private int visitorTeam;
    private String phase;
    private int bracket;
    private String winner;

    public Matchup(int id, int localTeam, int visitorTeam, String phase, int bracket, String winner) {
        this.id = id;
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.phase = phase;
        this.bracket = bracket;
        this.winner = winner;
    }

    public Matchup(int localTeam, int visitorTeam, String phase, int bracket, String winner) {
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.phase = phase;
        this.bracket = bracket;
        this.winner = winner;
    }

    public Matchup(int localTeam, int visitorTeam, String phase, int bracket) {
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.phase = phase;
        this.bracket = bracket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(int localTeam) {
        this.localTeam = localTeam;
    }

    public int getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(int visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public int getBracket() {
        return bracket;
    }

    public void setBracket(int bracket) {
        this.bracket = bracket;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Matchup{" +
                "id=" + id +
                ", localTeam=" + localTeam +
                ", visitorTeam=" + visitorTeam +
                ", phase='" + phase + '\'' +
                ", bracket=" + bracket +
                ", winner='" + winner + '\'' +
                '}';
    }
}
