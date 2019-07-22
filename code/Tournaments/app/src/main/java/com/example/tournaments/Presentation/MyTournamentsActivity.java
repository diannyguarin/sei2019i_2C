package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TournamentsAdapter;
import com.example.tournaments.businessLogic.Controllers.PopulateTournamentListController;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.models.User_tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import com.example.tournaments.dataAcces.repositories.User_tournamentRepository;

import java.util.ArrayList;

public class MyTournamentsActivity  extends Prueba {

    ListView listView;
    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    private PopulateTournamentListController populateTournamentListController;
    private User_tournamentRepository user_tournamentRepository;
    private ArrayList<Tournament> tournaments = new ArrayList<>();
    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_my_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tournament list");
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");


        listView = (ListView) findViewById(R.id.list);
        populateTournamentList();
    }



    public ArrayList<Tournament> getTournaments(){
        user_tournamentRepository = new User_tournamentRepository();
        tournamentRepository = new TournamentRepository();
        try{

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prro", Toast.LENGTH_SHORT).show();
        }
        return tournaments;
    }

    // Cambio

    public void populateTournamentList(){
        populateTournamentListController = new PopulateTournamentListController();
        TournamentsAdapter tournamentsAdapter = new TournamentsAdapter(MyTournamentsActivity.this, populateTournamentListController.getTournaments());
        listView.setAdapter(tournamentsAdapter);
    }
}
