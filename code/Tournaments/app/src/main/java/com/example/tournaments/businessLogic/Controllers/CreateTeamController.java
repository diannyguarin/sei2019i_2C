package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.repositories.TeamRepository;

public class CreateTeamController {
    private TeamRepository teamRepository;

    public boolean createTeam(String name, int currentUser){
        boolean success = false;
        teamRepository = new TeamRepository();
        try{
            success = teamRepository.createTeam(name, currentUser);
        }catch(Exception e){
            return success;
        }
        return success;
    }
}