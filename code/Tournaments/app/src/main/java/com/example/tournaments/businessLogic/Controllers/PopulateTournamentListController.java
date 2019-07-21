package com.example.tournaments.businessLogic.Controllers;

import android.widget.Toast;

import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;

import java.util.ArrayList;

public class PopulateTournamentListController {

    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    private ArrayList<Tournament> tournaments = new ArrayList<>();

    public ArrayList<Tournament> getTournaments(){
        tournamentRepository = new TournamentRepository();
        try{
            tournaments = tournamentRepository.getAllTournaments();
        }catch(Exception e){
            return null;
        }
        return tournaments;
    }
}