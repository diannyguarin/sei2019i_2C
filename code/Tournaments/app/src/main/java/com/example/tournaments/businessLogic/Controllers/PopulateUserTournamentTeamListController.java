package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.models.TempTournamentTeamData;
import com.example.tournaments.dataAcces.models.TempUserTournamentData;
import com.example.tournaments.dataAcces.repositories.User_tournament_teamRepository;

import java.util.ArrayList;

public class PopulateUserTournamentTeamListController {
    private ArrayList<TempTournamentTeamData> tempTournamentTeamDataArrayList;
    private User_tournament_teamRepository userTournamentTeamRepository;

    public ArrayList<TempTournamentTeamData> getAllUserTournamentTeams(int userTournamentId){
        userTournamentTeamRepository = new User_tournament_teamRepository();
        try{
            tempTournamentTeamDataArrayList = userTournamentTeamRepository.getAllUserTournamentTeamsImproved(userTournamentId);
        }catch(Exception e){
            return null;
        }
        return tempTournamentTeamDataArrayList;
    }
}
