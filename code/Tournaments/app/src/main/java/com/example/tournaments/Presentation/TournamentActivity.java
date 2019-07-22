package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;

import java.util.ArrayList;

public class TournamentActivity extends AppCompatActivity {
    ListView listView;
    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    private ArrayList<Tournament> tournaments = new ArrayList<>();
    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tournaments);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tournament list");
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");

        Button bBackHome = (Button) findViewById(R.id.bBackHome);
        bBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent3 = new Intent(TournamentActivity.this, BracketsActivity.class);
                    intent3.putExtra("currentUser", currentUsername);
                    startActivity(intent3);
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                    finish();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }

            }});
    }

}
