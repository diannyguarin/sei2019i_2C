package com.example.tournaments.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.SignupController;
import com.example.tournaments.businessLogic.Controllers.UpdateController;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;

import java.util.ArrayList;

import static com.example.tournaments.R.id.bChangeData;

public class UserHomeActivity extends Prueba {

    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    String currentUsername;
    private ArrayList<Tournament> tournaments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");



        Button bChangeData = (Button) findViewById(R.id.bChangeData);
        bChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try{
                        Intent intent = new Intent(UserHomeActivity.this, UserUpdateDataActivity.class);
                        intent.putExtra("currentUser", currentUsername);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                        finish();
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                    }

            }});

        ImageView bBack = (ImageView) findViewById(R.id.bBack);
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent1 = new Intent(UserHomeActivity.this, LoginActivity.class);
                    startActivity(intent1);
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                    finish();
            }});
        Button bTournaments = (Button) findViewById(R.id.bTournaments);
        bTournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent3 = new Intent(UserHomeActivity.this, UserHomeListActivity.class);

                    intent3.putExtra("currentUser", currentUsername);
                    startActivity(intent3);
                    finish();
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }

            }});
        //Toast.makeText(getApplicationContext(), ""+getTournaments(), Toast.LENGTH_SHORT).show();







    }

    /*public ArrayList<Tournament> getTournaments(){
        tournamentRepository = new TournamentRepository();
        try{
            tournaments = tournamentRepository.getAllTournaments();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prro", Toast.LENGTH_SHORT).show();
        }
        return tournaments;
    }*/
}

/*try {
        Intent intent = new Intent(UserHomeActivity.this, UserUpdateDataActivity.class);
        startActivity(intent);
        finish();
        } catch (Exception e) {
        Toast.makeText(getApplicationContext(), "The data you have entered is not correct.", Toast.LENGTH_SHORT).show();
        }*/