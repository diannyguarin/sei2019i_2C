package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TeamsAdapter;
import com.example.tournaments.businessLogic.Controllers.PopulateTeamListController;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.Tournament;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateTournamentSelectTeams extends AppCompatActivity {
    ArrayList<Team> userTeamsArray = new ArrayList<>();
    ArrayList<Team> tournamentTeamsArray = new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament_select_teams);

        Intent intent = getIntent();
        Bundle extras = this.getIntent().getExtras();
        Bundle args = intent.getBundleExtra("BUNDLE");
        final int currentUserId = extras.getInt("currentUserId");
        final int tournamentId = extras.getInt("tournamentId");
        userTeamsArray = (ArrayList<Team>) args.getSerializable("userTeams");
        tournamentTeamsArray = (ArrayList<Team>) args.getSerializable("tourTeams");


        listView = (ListView) findViewById(R.id.list);
        populateTeamList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tournamentTeamsArray.add(userTeamsArray.get(i));
                userTeamsArray.remove(i);
                TeamsAdapter teamsAdapter = new TeamsAdapter(CreateTournamentSelectTeams.this, userTeamsArray);
                listView.setAdapter(teamsAdapter);
            }
        });


        FloatingActionButton goBack = findViewById(R.id.fab2);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTournamentSelectTeams.this, CreateTournamentTeamsQuarters.class);
                Bundle args = new Bundle();
                args.putSerializable("userTeams",(Serializable)userTeamsArray);
                args.putSerializable("tourTeams",(Serializable)tournamentTeamsArray);
                intent.putExtra("previousActivity", "selectTeams");
                intent.putExtra("currentUserId", currentUserId);
                intent.putExtra("tournamentId", tournamentId);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });
    }

    public void populateTeamList(){
        if(userTeamsArray.isEmpty()){

        }else{
            PopulateTeamListController populateTeamListController = new PopulateTeamListController();
            TeamsAdapter teamsAdapter = new TeamsAdapter(CreateTournamentSelectTeams.this, userTeamsArray);
            listView.setAdapter(teamsAdapter);
        }
    }

}
