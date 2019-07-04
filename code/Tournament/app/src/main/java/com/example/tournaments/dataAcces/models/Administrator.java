package com.example.tournaments.dataAcces.models;

public class Administrator {
    private int id;
    private String username;
    private String password;

    public Administrator(String username, String password){
        this.username=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
