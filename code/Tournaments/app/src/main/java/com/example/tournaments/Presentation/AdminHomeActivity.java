package com.example.tournaments.Presentation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TournamentsAdapter;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;

import java.util.ArrayList;

public class AdminHomeActivity extends Prueba2 {
    ListView listView;
    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    private ArrayList<Tournament> tournaments = new ArrayList<>();
    String currentUsername;

    private TextView tv_role;
    FloatingActionButton newT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tournament list");
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");

        newT = (FloatingActionButton) findViewById(R.id.newTour);
        newT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, CreateTournamentActivity.class);
                startActivity(intent);
                finish();
            }
        });

        listView = (ListView) findViewById(R.id.list2);
        populateTournamentList();

    }

    public ArrayList<Tournament> getTournaments(){
        tournamentRepository = new TournamentRepository();
        try{
            tournaments = tournamentRepository.getAllTournaments();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prro", Toast.LENGTH_SHORT).show();
        }
        return tournaments;
    }

    public void populateTournamentList(){
        TournamentsAdapter tournamentsAdapter2 = new TournamentsAdapter(AdminHomeActivity.this, getTournaments());
        listView.setAdapter(tournamentsAdapter2);
    }


}
