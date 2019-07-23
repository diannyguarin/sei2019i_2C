package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.models.Matchup;
import com.example.tournaments.dataAcces.models.TempTournamentTeamData;
import com.example.tournaments.dataAcces.models.TempUserTournamentData;
import com.example.tournaments.dataAcces.repositories.MatchupRepository;
import com.example.tournaments.dataAcces.repositories.User_tournament_teamRepository;

import java.util.ArrayList;

public class CreateMatchupsController {
    private MatchupRepository matchupRepository;
    private Matchup matchup;
    private ArrayList<Matchup> matchupArrayList = new ArrayList<>();

    public boolean createMatchups(ArrayList<TempTournamentTeamData> tempTournamentTeamDataArrayList){
        boolean success = false;
        matchupRepository = new MatchupRepository();
        try{
            int bracketCounter = 0;
            switch(tempTournamentTeamDataArrayList.size()){
                case 2:
                    for(int i = 0; i<tempTournamentTeamDataArrayList.size(); i+=2){
                       matchupArrayList.add(new Matchup(tempTournamentTeamDataArrayList.get(i).getIdTournamentTeam(), tempTournamentTeamDataArrayList.get(i+1).getIdTournamentTeam(), "final", 1));
                    }
                    break;
                case 4:
                    bracketCounter = 0;
                    for(int i = 0; i<tempTournamentTeamDataArrayList.size(); i+=2){
                        matchupArrayList.add(new Matchup(tempTournamentTeamDataArrayList.get(i).getIdTournamentTeam(), tempTournamentTeamDataArrayList.get(i+1).getIdTournamentTeam(), "semis", bracketCounter+1));
                        bracketCounter++;
                    }
                    break;
                case 8:
                    bracketCounter = 0;
                    for(int i = 0; i<tempTournamentTeamDataArrayList.size(); i+=2){
                        matchupArrayList.add(new Matchup(tempTournamentTeamDataArrayList.get(i).getIdTournamentTeam(), tempTournamentTeamDataArrayList.get(i+1).getIdTournamentTeam(), "quarters", bracketCounter+1));
                        bracketCounter++;
                    }
                    break;
                case 16:
                    bracketCounter = 0;
                    for(int i = 0; i<tempTournamentTeamDataArrayList.size(); i+=2){
                        matchupArrayList.add(new Matchup(tempTournamentTeamDataArrayList.get(i).getIdTournamentTeam(), tempTournamentTeamDataArrayList.get(i+1).getIdTournamentTeam(), "sixteen", bracketCounter+1));
                        bracketCounter++;
                    }
                    break;
            }
            success = matchupRepository.createMatchupsImproved(matchupArrayList);
        }catch(Exception e){
            return false;
        }
        return success;
    }
}
