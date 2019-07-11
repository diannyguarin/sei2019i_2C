package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.repositories.TournamentRepository;

public class CreateTournamentController {
    private TournamentRepository tournamentRepository;

    public boolean createTournament(String name, int sport, int tournamentType, int numberOfTeams){
        boolean success = false;
        try{
            tournamentRepository = new TournamentRepository();
            success = tournamentRepository.createTournament(name, sport, tournamentType, numberOfTeams);
        }catch(Exception e){
            return false;
        }
        return success;
    }
}
