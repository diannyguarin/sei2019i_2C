package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.repositories.TournamentRepository;

public class CreateTournamentController {
    private TournamentRepository tournamentRepository;

    public boolean createTournament(int id, String name,int admin,int sport, int tournamentType, int numberOfTeams){
        boolean success = false;
        try{
            tournamentRepository = new TournamentRepository();
            success = tournamentRepository.createTournament(id,name,admin,sport, tournamentType, numberOfTeams);
        }catch(Exception e){}
        return success;
    }
}
