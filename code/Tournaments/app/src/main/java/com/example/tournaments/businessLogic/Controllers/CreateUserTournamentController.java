package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.User_tournament;
import com.example.tournaments.dataAcces.repositories.User_tournamentRepository;
import com.example.tournaments.dataAcces.repositories.User_tournament_teamRepository;

import java.util.ArrayList;

public class CreateUserTournamentController {
    private User_tournamentRepository userTournamentRepository;
    private User_tournament_teamRepository userTournamentTeamRepository;
    private User_tournament userTournament;

    public User_tournament createUserTournament(int currentUserId, int tournamentId, ArrayList<Team> tournamentTeams){
        boolean teamSuccess = false;
        userTournamentRepository = new User_tournamentRepository();
        try {
            userTournamentRepository.createUser_tournament(currentUserId, tournamentId);
            try{
                userTournament = userTournamentRepository.getUserTournamentByIdImproved(currentUserId);
                teamSuccess= addTeams(userTournament.getId(), tournamentTeams);
                if (teamSuccess ==false){
                    return null;
                }
            }catch(Exception e){

            }
        }catch(Exception e){
            return null;
        }

        return userTournament;
    }

    public boolean addTeams(int userTournamentId, ArrayList<Team> tournamentTeams) {
        boolean teamsSuccess = false;
        userTournamentTeamRepository = new User_tournament_teamRepository();
        try{
            teamsSuccess = userTournamentTeamRepository.createUserTournamentTeamImproved(userTournamentId, tournamentTeams);
        }catch(Exception e){
            return false;
        }
        return teamsSuccess;
    }
}
