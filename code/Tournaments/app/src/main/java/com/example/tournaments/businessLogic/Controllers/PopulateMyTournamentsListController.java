package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.TempUserTournamentData;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.models.User_tournament;
import com.example.tournaments.dataAcces.repositories.TeamRepository;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import com.example.tournaments.dataAcces.repositories.User_tournamentRepository;

import java.util.ArrayList;

public class PopulateMyTournamentsListController {
    private User_tournamentRepository userTournamentRepository;
    private TournamentRepository tournamentRepository;
    private TempUserTournamentData tempUserTournamentData;
    private Tournament tournament;
    private ArrayList<Tournament> tournaments = new ArrayList<>();
    private ArrayList<User_tournament> userTournaments;
    private ArrayList<TempUserTournamentData> tempUserTournamentDataArrayList = new ArrayList<>();

    public ArrayList<TempUserTournamentData> getAllUserTournaments(int idCurrentUser){
        userTournamentRepository = new User_tournamentRepository();
        try{
            tempUserTournamentDataArrayList = userTournamentRepository.getAllUserTournamentsByUserIdImproved(idCurrentUser);
        }catch(Exception e){
            return null;
        }
        return tempUserTournamentDataArrayList;
    }
}
