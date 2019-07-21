package com.example.tournaments.Presentation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.CreateTournamentController;
import com.example.tournaments.dataAcces.repositories.SportRepository;
import com.example.tournaments.dataAcces.repositories.TypeRepository;

public class NewTeamActivity extends AppCompatActivity {

    String currentUsername;

    private EditText t_name;
    private Button btn_create;
    private CreateTournamentController createTournamentController;
    private int sport;
    private int tournType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_team);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Teams");
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");


        t_name = (EditText) findViewById(R.id.t_name);


    }


}