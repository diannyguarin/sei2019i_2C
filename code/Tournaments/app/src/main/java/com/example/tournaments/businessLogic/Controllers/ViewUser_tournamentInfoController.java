package com.example.tournaments.businessLogic.Controllers;

import com.example.tournaments.dataAcces.models.Matchup;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.models.User_tournament;
import com.example.tournaments.dataAcces.models.User_tournament_team;
import com.example.tournaments.dataAcces.repositories.MatchupRepository;
import com.example.tournaments.dataAcces.repositories.TeamRepository;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import com.example.tournaments.dataAcces.repositories.User_tournamentRepository;
import com.example.tournaments.dataAcces.repositories.User_tournament_teamRepository;

import java.util.ArrayList;

public class ViewUser_tournamentInfoController {
    private String[][] results;
    private User_tournament user_tournament;
    private ArrayList<User_tournament_team> user_tournament_teams;
    private ArrayList<Matchup> matchups;
    private Tournament tournament;
    private int size;
    private int phases;
    private String champion;

    private User_tournamentRepository user_tournamentRepository;
    private User_tournament_teamRepository user_tournament_teamRepository;
    private MatchupRepository matchupRepository;
    private TournamentRepository tournamentRepository;
    private TeamRepository teamRepository;

    public ViewUser_tournamentInfoController(int user_tournamentId) {
        this.user_tournamentRepository = new User_tournamentRepository();
        this.user_tournament_teamRepository = new User_tournament_teamRepository();
        this.matchupRepository = new MatchupRepository();
        this.tournamentRepository = new TournamentRepository();
        this.teamRepository = new TeamRepository();

        this.user_tournament = this.user_tournamentRepository.getUser_tournamentById(user_tournamentId);
        this.user_tournament_teams = this.user_tournament_teamRepository.getUser_tournament_teamsByUser_tournament(user_tournamentId);
        for (int i = 0; i < this.user_tournament_teams.size(); i++) {
            this.matchups.addAll(this.matchupRepository.getMatchupsByLocalTeam(this.user_tournament_teams.get(i).getId()));
        }
        this.tournament = this.tournamentRepository.getTournamentById(this.user_tournament.getTournament());
        this.size = this.tournament.getNumberOfTeams() - 1;
        if (this.size == 1) {//2 teams
            this.phases = 1;
        } else if (this.size == 3) {//4 teams
            this.phases = 2;
        } else if (this.size == 7) {//8 teams
            this.phases = 3;
        } else if (this.size == 15) {//16 teams
            this.phases = 4;
        }
        this.results = new String[8][this.size];
        for (int p = 1; p < this.phases + 1; p++) {
            if (p == 1) {
                int counter = 2;
                for (int i = 0; i < this.matchups.size(); i++) {
                    if (this.matchups.get(i).getPhase() == "final") {
                        this.results[0][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getId());// match id
                        this.results[1][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getLocalTeam());// local id
                        this.results[2][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getLocalTeam()).getTeam()).getName();// local name
                        this.results[3][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getVisitorTeam());// visitor id
                        this.results[4][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getVisitorTeam()).getTeam()).getName();// visitor name
                        this.results[5][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getPhase();// phase
                        this.results[6][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getBracket());// bracket
                        this.results[7][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getWinner();// winner
                    }
                }
            } else if (p == 2) {
                int counter = 4;
                for (int i = 0; i < this.matchups.size(); i++) {
                    if (this.matchups.get(i).getPhase() == "semis") {
                        this.results[0][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getId());// match id
                        this.results[1][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getLocalTeam());// local id
                        this.results[2][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getLocalTeam()).getTeam()).getName();// local name
                        this.results[3][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getVisitorTeam());// visitor id
                        this.results[4][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getVisitorTeam()).getTeam()).getName();// visitor name
                        this.results[5][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getPhase();// phase
                        this.results[6][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getBracket());// bracket
                        this.results[7][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getWinner();// winner
                    }
                }
            } else if (p == 3) {
                int counter = 8;
                for (int i = 0; i < this.matchups.size(); i++) {
                    if (this.matchups.get(i).getPhase() == "quarters") {
                        this.results[0][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getId());// match id
                        this.results[1][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getLocalTeam());// local id
                        this.results[2][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getLocalTeam()).getTeam()).getName();// local name
                        this.results[3][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getVisitorTeam());// visitor id
                        this.results[4][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getVisitorTeam()).getTeam()).getName();// visitor name
                        this.results[5][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getPhase();// phase
                        this.results[6][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getBracket());// bracket
                        this.results[7][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getWinner();// winner
                    }
                }
            } else if (p == 4) {
                int counter = 16;
                for (int i = 0; i < this.matchups.size(); i++) {
                    if (this.matchups.get(i).getPhase() == "eighths") {
                        this.results[0][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getId());// match id
                        this.results[1][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getLocalTeam());// local id
                        this.results[2][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getLocalTeam()).getTeam()).getName();// local name
                        this.results[3][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getVisitorTeam());// visitor id
                        this.results[4][this.size + (this.matchups.get(i).getBracket() - counter)] = this.teamRepository.getTeamById(this.user_tournament_teamRepository.getUser_tournament_teamById(this.matchups.get(i).getVisitorTeam()).getTeam()).getName();// visitor name
                        this.results[5][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getPhase();// phase
                        this.results[6][this.size + (this.matchups.get(i).getBracket() - counter)] = String.valueOf(this.matchups.get(i).getBracket());// bracket
                        this.results[7][this.size + (this.matchups.get(i).getBracket() - counter)] = this.matchups.get(i).getWinner();// winner
                    }
                }
            }
        }
        for (int i = this.matchups.size(); i < this.size; i++) {
            this.results[0][i] = "-1";// match id
            this.results[1][i] = "-1";// local id
            this.results[2][i] = "TBD";// local name
            this.results[3][i] = "-1";// visitor id
            this.results[4][i] = "TBD";// visitor name
            this.results[5][i] = "TBD";// phase
            this.results[6][i] = "-1";// bracket
            this.results[7][i] = "TBD";// winner
        }
    }

    public String[][] getResults() {
        return results;
    }

    public String[][] selectWinner(String phase, String bracket, String winnerName) {
        if (phase == "final") {
            int counter = 2;
            if (Integer.valueOf(bracket) == 1) {
                if (results[2][size + (Integer.valueOf(bracket) - counter)] == winnerName || results[4][size - (counter + Integer.valueOf(bracket))] == winnerName) {
                    results[7][size + (Integer.valueOf(bracket) - counter)] = winnerName;
                }
            }
        } else if (phase == "semis") {
            int counter = 4;
            if (Integer.valueOf(bracket) > 0 && Integer.valueOf(bracket) < 3) {
                if (results[2][size + (Integer.valueOf(bracket) - counter)] == winnerName || results[4][size - (counter + Integer.valueOf(bracket))] == winnerName) {
                    results[7][size + (Integer.valueOf(bracket) - counter)] = winnerName;
                }
            }
        } else if (phase == "quarters") {
            int counter = 8;
            if (Integer.valueOf(bracket) > 0 && Integer.valueOf(bracket) < 5) {
                if (results[2][size + (Integer.valueOf(bracket) - counter)] == winnerName || results[4][size - (counter + Integer.valueOf(bracket))] == winnerName) {
                    results[7][size + (Integer.valueOf(bracket) - counter)] = winnerName;
                }
            }
        } else if (phase == "eighths") {
            int counter = 16;
            if (Integer.valueOf(bracket) > 0 && Integer.valueOf(bracket) < 9) {
                if (results[2][size + (Integer.valueOf(bracket) - counter)] == winnerName || results[4][size - (counter + Integer.valueOf(bracket))] == winnerName) {
                    results[7][size + (Integer.valueOf(bracket) - counter)] = winnerName;
                }
            }
        }
        return results;
    }

    public String[][] confirmPhase(String phase) {
        if (phase == "semis") {
            int counter = 2;
            int prevBracket = 1;
            int nextBracket = 1;

            String matchId;// match id
            String localId;
            if (results[7][size + (prevBracket - counter)] == results[2][size + (prevBracket - counter)]) {
                localId = results[1][size + (prevBracket - counter)];// local id
            } else {
                localId = results[3][size + (prevBracket - counter)];// local id
            }
            String localName = results[7][size + (prevBracket - counter)];// local name
            matchupRepository.updateMatchupWinner(localName, Integer.valueOf(results[0][size + (prevBracket - counter)]));
            prevBracket++;
            String visitorId;
            if (results[7][size + (prevBracket - counter)] == results[2][size + (prevBracket - counter)]) {
                visitorId = results[1][size + (prevBracket - counter)];// local id
            } else {
                visitorId = results[3][size + (prevBracket - counter)];// local id
            }
            String visitorName = results[7][size + (prevBracket - counter)];// visitor name
            matchupRepository.updateMatchupWinner(visitorName, Integer.valueOf(results[0][size + (prevBracket - counter)]));
            String nextPhase = "final";// phase
            String bracket = String.valueOf(nextBracket);// bracket
            String winner = "TBD";// winner

            matchupRepository.createMatchup(Integer.valueOf(localId), Integer.valueOf(visitorId), nextPhase, Integer.valueOf(bracket), winner);
            Matchup match = matchupRepository.getMatchupByLocalAndVisitor(Integer.valueOf(localId), Integer.valueOf(visitorId));
            matchId = String.valueOf(match.getId());

            results[0][size + (nextBracket - counter)] = matchId;// match id
            results[1][size + (nextBracket - counter)] = localId;// local id
            results[2][size + (nextBracket - counter)] = localName;// local name
            results[3][size + (nextBracket - counter)] = visitorId;// visitor id
            results[4][size + (nextBracket - counter)] = visitorName;// visitor name
            results[5][size + (nextBracket - counter)] = nextPhase;// phase
            results[6][size + (nextBracket - counter)] = bracket;// bracket
            results[7][size + (nextBracket - counter)] = winner;// winner
            nextBracket++;

        } else if (phase == "quarters") {
            int counter = 4;
            int prevBracket = 1;
            int nextBracket = 1;
            while (nextBracket != 2) {
                String matchId;// match id
                String localId;
                if (results[7][size + (prevBracket - counter)] == results[2][size + (prevBracket - counter)]) {
                    localId = results[1][size + (prevBracket - counter)];// local id
                } else {
                    localId = results[3][size + (prevBracket - counter)];// local id
                }
                String localName = results[7][size + (prevBracket - counter)];// local name
                matchupRepository.updateMatchupWinner(localName, Integer.valueOf(results[0][size + (prevBracket - counter)]));
                prevBracket++;
                String visitorId;
                if (results[7][size + (prevBracket - counter)] == results[2][size + (prevBracket - counter)]) {
                    visitorId = results[1][size + (prevBracket - counter)];// local id
                } else {
                    visitorId = results[3][size + (prevBracket - counter)];// local id
                }
                String visitorName = results[7][size + (prevBracket - counter)];// visitor name
                matchupRepository.updateMatchupWinner(visitorName, Integer.valueOf(results[0][size + (prevBracket - counter)]));
                String nextPhase = "semis";// phase
                String bracket = String.valueOf(nextBracket);// bracket
                String winner = "TBD";// winner

                matchupRepository.createMatchup(Integer.valueOf(localId), Integer.valueOf(visitorId), nextPhase, Integer.valueOf(bracket), winner);
                Matchup match = matchupRepository.getMatchupByLocalAndVisitor(Integer.valueOf(localId), Integer.valueOf(visitorId));
                matchId = String.valueOf(match.getId());

                results[0][size + (nextBracket - counter)] = matchId;// match id
                results[1][size + (nextBracket - counter)] = localId;// local id
                results[2][size + (nextBracket - counter)] = localName;// local name
                results[3][size + (nextBracket - counter)] = visitorId;// visitor id
                results[4][size + (nextBracket - counter)] = visitorName;// visitor name
                results[5][size + (nextBracket - counter)] = nextPhase;// phase
                results[6][size + (nextBracket - counter)] = bracket;// bracket
                results[7][size + (nextBracket - counter)] = winner;// winner
                nextBracket++;
            }

        } else if (phase == "eighths") {
            int counter = 8;
            int prevBracket = 1;
            int nextBracket = 1;
            while (nextBracket != 4) {
                String matchId;// match id
                String localId;
                if (results[7][size + (prevBracket - counter)] == results[2][size + (prevBracket - counter)]) {
                    localId = results[1][size + (prevBracket - counter)];// local id
                } else {
                    localId = results[3][size + (prevBracket - counter)];// local id
                }
                String localName = results[7][size + (prevBracket - counter)];// local name
                matchupRepository.updateMatchupWinner(localName, Integer.valueOf(results[0][size + (prevBracket - counter)]));
                prevBracket++;
                String visitorId;
                if (results[7][size + (prevBracket - counter)] == results[2][size + (prevBracket - counter)]) {
                    visitorId = results[1][size + (prevBracket - counter)];// local id
                } else {
                    visitorId = results[3][size + (prevBracket - counter)];// local id
                }
                String visitorName = results[7][size + (prevBracket - counter)];// visitor name
                matchupRepository.updateMatchupWinner(visitorName, Integer.valueOf(results[0][size + (prevBracket - counter)]));
                String nextPhase = "quarters";// phase
                String bracket = String.valueOf(nextBracket);// bracket
                String winner = "TBD";// winner

                matchupRepository.createMatchup(Integer.valueOf(localId), Integer.valueOf(visitorId), nextPhase, Integer.valueOf(bracket), winner);
                Matchup match = matchupRepository.getMatchupByLocalAndVisitor(Integer.valueOf(localId), Integer.valueOf(visitorId));
                matchId = String.valueOf(match.getId());

                results[0][size + (nextBracket - counter)] = matchId;// match id
                results[1][size + (nextBracket - counter)] = localId;// local id
                results[2][size + (nextBracket - counter)] = localName;// local name
                results[3][size + (nextBracket - counter)] = visitorId;// visitor id
                results[4][size + (nextBracket - counter)] = visitorName;// visitor name
                results[5][size + (nextBracket - counter)] = nextPhase;// phase
                results[6][size + (nextBracket - counter)] = bracket;// bracket
                results[7][size + (nextBracket - counter)] = winner;// winner
                nextBracket++;
            }
        }
        return results;
    }

    public String endTournament() {
        matchupRepository.updateMatchupWinner(results[7][size - 1], Integer.valueOf(results[0][size - 1]));
        champion = results[7][size - 1];
        return champion;
    }

}
