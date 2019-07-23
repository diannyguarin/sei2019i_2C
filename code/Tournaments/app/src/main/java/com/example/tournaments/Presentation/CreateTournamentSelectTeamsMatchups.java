package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TeamsAdapter;
import com.example.tournaments.businessLogic.Adapters.TournamentTeamsAdapter;
import com.example.tournaments.businessLogic.Controllers.PopulateTeamListController;
import com.example.tournaments.businessLogic.Controllers.PopulateUserTournamentTeamListController;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.TempTournamentTeamData;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateTournamentSelectTeamsMatchups extends AppCompatActivity {
    ArrayList<TempTournamentTeamData> tournamentTeamDataArrayList = new ArrayList<>();
    ArrayList<TempTournamentTeamData> tournamentTeamDataMatchupArraylist = new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament_select_teams_matchups);

        Intent intent = getIntent();
        Bundle extras = this.getIntent().getExtras();
        String currentUsername = extras.getString("currentUser");
        String previousActivity = extras.getString("previousActivity");
        final int currentUserId = extras.getInt("currentUserId");
        final int tournamentId = extras.getInt("tournamentId");
        final int bracket = extras.getInt("bracket");
        if (previousActivity.equals("selectTeams")){
            Bundle args = intent.getBundleExtra("BUNDLE");
            tournamentTeamDataArrayList = (ArrayList<TempTournamentTeamData>) args.getSerializable("tournamentTeam");
            tournamentTeamDataMatchupArraylist = (ArrayList<TempTournamentTeamData>) args.getSerializable("tournamentTeamMatchup");
        }
//        tournamentTeamDataArrayList = (ArrayList<TempTournamentTeamData>) args.getSerializable("tournamentTeam");
//        tournamentTeamDataMatchupArraylist = (ArrayList<TempTournamentTeamData>) args.getSerializable("tournamentTeamMatchup");


        listView = (ListView) findViewById(R.id.list);
        populateTeamList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (bracket) {
                    case 0:

                            tournamentTeamDataMatchupArraylist.add(bracket, tournamentTeamDataArrayList.get(i));
                            tournamentTeamDataArrayList.remove(i);
                            TournamentTeamsAdapter teamsAdapter = new TournamentTeamsAdapter(CreateTournamentSelectTeamsMatchups.this, tournamentTeamDataArrayList);
                            listView.setAdapter(teamsAdapter);
                        break;
                }
            }
        });


        FloatingActionButton goBack = findViewById(R.id.fab2);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTournamentSelectTeamsMatchups.this, CreateTournamentQuartersMatchups.class);
                Bundle args = new Bundle();
                args.putSerializable("tournamentTeam",(Serializable)tournamentTeamDataArrayList);
                args.putSerializable("tournamentTeamMatchup",(Serializable)tournamentTeamDataMatchupArraylist);
                intent.putExtra("previousActivity", "selectTeams");
                intent.putExtra("currentUserId", currentUserId);
                intent.putExtra("tournamentId", tournamentId);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });
    }

    public void populateTeamList(){
        if(tournamentTeamDataArrayList.isEmpty()){

        }else{
            PopulateUserTournamentTeamListController populateTeamListController = new PopulateUserTournamentTeamListController();
            TournamentTeamsAdapter teamsAdapter = new TournamentTeamsAdapter(CreateTournamentSelectTeamsMatchups.this, tournamentTeamDataArrayList);
            listView.setAdapter(teamsAdapter);
        }
    }

}
