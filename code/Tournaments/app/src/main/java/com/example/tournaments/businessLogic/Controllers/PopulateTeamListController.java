package com.example.tournaments.businessLogic.Controllers;

import android.widget.Toast;

import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.repositories.TeamRepository;

import java.util.ArrayList;

public class PopulateTeamListController {

    private TeamRepository teamRepository;
    private Team team;

    private ArrayList<Team> teams = new ArrayList<>();

    public ArrayList<Team> getTeams(int currentUserId){
        teamRepository = new TeamRepository();
        try{
            teams = teamRepository.getAllTeamsByUserId(currentUserId);
        }catch(Exception e){
            return null;
        }
        return teams;
    }
}