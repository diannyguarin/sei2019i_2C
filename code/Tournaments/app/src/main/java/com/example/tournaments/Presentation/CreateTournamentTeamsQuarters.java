package com.example.tournaments.Presentation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TeamsAdapter;
import com.example.tournaments.businessLogic.Controllers.CreateUserTournamentController;
import com.example.tournaments.businessLogic.Controllers.PopulateTeamListController;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.models.User_tournament;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateTournamentTeamsQuarters extends AppCompatActivity {

    ArrayList<Team> userTeamsArray = new ArrayList<>();
    ArrayList<Team> tournamentTeamsArray = new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament_teams_quarters);

        int numberOfTeams = 8;

        Intent intent = getIntent();
        Bundle extras = this.getIntent().getExtras();
        String currentUsername = extras.getString("currentUser");
        String previousActivity = extras.getString("previousActivity");
        final int currentUserId = extras.getInt("currentUserId");
        final int tournamentId = extras.getInt("tournamentId");
        if (previousActivity.equals("selectTeams")){
            Bundle args = intent.getBundleExtra("BUNDLE");
            userTeamsArray = (ArrayList<Team>) args.getSerializable("userTeams");
            tournamentTeamsArray = (ArrayList<Team>) args.getSerializable("tourTeams");
        }


        if(userTeamsArray.isEmpty() && previousActivity.equals("userHomeList")){
            PopulateTeamListController populateTeamListController = new PopulateTeamListController();
            userTeamsArray = populateTeamListController.getTeams(currentUserId);
        }


        listView = (ListView) findViewById(R.id.list);

        populateTeamList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                userTeamsArray.add(tournamentTeamsArray.get(i));
                tournamentTeamsArray.remove(i);
                TeamsAdapter teamsAdapter = new TeamsAdapter(CreateTournamentTeamsQuarters.this, tournamentTeamsArray);
                listView.setAdapter(teamsAdapter);
            }
        });


        FloatingActionButton selectTeams = findViewById(R.id.fab);

        selectTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTournamentTeamsQuarters.this, CreateTournamentSelectTeams.class);
                Bundle args = new Bundle();
                intent.putExtra("currentUserId", currentUserId);
                intent.putExtra("tournamentId", tournamentId);
                args.putSerializable("userTeams",(Serializable)userTeamsArray);
                args.putSerializable("tourTeams",(Serializable)tournamentTeamsArray);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });

        FloatingActionButton goToMatchups = findViewById(R.id.fab2);

        goToMatchups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tournamentTeamsArray.size() == 8){
                    CreateUserTournamentController createUserTournamentController = new CreateUserTournamentController();
                    User_tournament userTournament = createUserTournamentController.createUserTournament(currentUserId, tournamentId, tournamentTeamsArray);
                    Intent intent = new Intent(CreateTournamentTeamsQuarters.this, CreateTournamentQuartersMatchups.class);
                    intent.putExtra("userTournamentId", userTournament.getId());
                    intent.putExtra("currentUser", userTournament.getId());
                    intent.putExtra("currentUserId", userTournament.getId());
                    intent.putExtra("previousActivity", "createTournament");
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "The selected tournament must have 8 teams.", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public void populateTeamList(){
        if(tournamentTeamsArray.isEmpty()){

        }else{
            PopulateTeamListController populateTeamListController = new PopulateTeamListController();
            TeamsAdapter teamsAdapter = new TeamsAdapter(CreateTournamentTeamsQuarters.this, tournamentTeamsArray);
            listView.setAdapter(teamsAdapter);
        }

    }
}
