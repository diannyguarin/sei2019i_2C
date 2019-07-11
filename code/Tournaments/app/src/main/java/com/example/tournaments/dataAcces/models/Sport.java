package com.example.tournaments.dataAcces.models;

public class Sport {
    private int id;
    private String sportname;

    public Sport(int id, String sportname) {
        this.id = id;
        this.sportname = sportname;
    }

    public Sport(String sportname) {
        this.sportname = sportname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsportname() {
        return sportname;
    }

    public void setsportname(String sportname) {
        this.sportname = sportname;
    }

    @Override
    public String toString() {
        return "Sports{" + "id=" + id + ", name='" + sportname + '\'' + '}';
    }
}

