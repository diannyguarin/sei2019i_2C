package com.example.tournaments.dataAcces.models;

public class Tournament_Type {
    private int id;
    private String Typename;

    public Tournament_Type(int id, String typename) {
        this.id = id;
        Typename = typename;
    }

    public Tournament_Type(String typename) {
        Typename = typename;
    }

    public int getId() {
        return id;
    }

    public String getTypename() {
        return Typename;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypename(String typename) {
        Typename = typename;
    }

    @Override
    public String toString() {
        return "Tournament_Type{" +
                "id=" + id +
                ", Typename='" + Typename + '\'' +
                '}';
    }
}
