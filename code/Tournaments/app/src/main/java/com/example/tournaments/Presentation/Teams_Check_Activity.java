package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TeamsCheckAdapter;
import com.example.tournaments.businessLogic.Controllers.PopulateTeamsCheckListController;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TeamRepository;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import com.example.tournaments.dataAcces.repositories.UserRepository;


import java.util.ArrayList;

public class Teams_Check_Activity extends Prueba {
    private PopulateTeamsCheckListController populateTeamCheckListController;


    Button fab;
    ListView listView;
    CheckBox CheckedTextView;
    ArrayAdapter miListViewAdapterMultiple;
    ArrayAdapter miListViewAdapterNone;
    //private ArrayList<Tournament> tournaments = new ArrayList<>();
    private ArrayList<Team> teams = new ArrayList<>();
    private TeamRepository teamRepository;
    private TournamentRepository tournamentRepository;
    private UserRepository userRepository;
    private int idTournament;
    //private Tournament tournament;
    private Team team;
    ArrayList<String> miListView2 = new ArrayList<>();
    //private User_tournamentRepository user_tournamentRepository;
    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_check);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Teams");

        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");
        idTournament = extras.getInt("idTournament");

        listView = (ListView) findViewById(R.id.list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        populateTeamCheckListController = new PopulateTeamsCheckListController();

        Intent intent3 = new Intent();
        intent3.putExtra("currentUser", currentUsername);
        intent3.putExtra("idTournament", idTournament);
        final TeamsCheckAdapter tournamentsAdapter2 = new TeamsCheckAdapter(Teams_Check_Activity.this, getTeams());
        miListViewAdapterMultiple = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, R.id.CheckedTextView, miListView2);

        int firstPosition = listView.getFirstVisiblePosition();
        listView.setSelection(firstPosition);
        listView.setAdapter(miListViewAdapterMultiple);

        tournamentRepository = new TournamentRepository();

        populateTeamList();
        populateTeamCheckListController = new PopulateTeamsCheckListController();
        fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTeam();

            }
        });
    }

    public ArrayList<Team> getTeams() {
        teamRepository = new TeamRepository();
        try {
            teams = teamRepository.getAllTeams();
        } catch (Exception e) {
            return null;
        }
        return teams;
    }

    public void populateTeamList() {
        populateTeamCheckListController = new PopulateTeamsCheckListController();
        TeamsCheckAdapter teamsCheckAdapter = new TeamsCheckAdapter(Teams_Check_Activity.this, populateTeamCheckListController.getTeams());
        listView.setAdapter(teamsCheckAdapter);

    }

    public void checkTeam() {

        int count = listView.getAdapter().getCount();

        if (count == tournamentRepository.getTournamentById(idTournament).getNumberOfTeams()) {
            for (int i = 0; i < count; i++) {
                ViewGroup row = (ViewGroup) listView.getChildAt(i);

                CheckedTextView = (CheckBox) row.findViewById(R.id.CheckedTextView);

                if (CheckedTextView.isChecked()) {
                    teams.add(teamRepository.getTeamById(row.getId()));

                    Toast.makeText(getApplicationContext(), "Team Added ", Toast.LENGTH_SHORT).show();


                } else
                    Toast.makeText(getApplicationContext(), "Team not added ", Toast.LENGTH_SHORT).show();
            }
            Intent intent3 = new Intent(Teams_Check_Activity.this, BracketsActivity.class);
            intent3.putExtra("currentUser", currentUsername);
            intent3.putExtra("teamsSelected",teams);
            startActivity(intent3);
            finish();
        }
    }

}





        /*
        CheckedTextView = (CheckBox) findViewById(R.id.CheckedTextView);
        tournamentRepository = new TournamentRepository();
        for (int i = 0; i <listView.getCount(); i++) {
            View v = listView.getChildAt(i);
            if (CheckedTextView.isChecked()||(listView.getCheckedItemCount()== tournamentRepository.getTournamentByName(currentUsername).getNumberOfTeams()))
            {   teams.add(teamRepository.getTeamById(v.getId()));
                Intent intent3 = new Intent(Teams_Check_Activity.this, BracketsActivity.class);
                intent3.putExtra("currentUser", currentUsername);
                startActivity(intent3);
                finish();
                Toast.makeText(getApplicationContext(), "Team Added ", Toast.LENGTH_SHORT).show();
            }else
            Toast.makeText(getApplicationContext(), "Team not added ", Toast.LENGTH_SHORT).show();}}
        */




















