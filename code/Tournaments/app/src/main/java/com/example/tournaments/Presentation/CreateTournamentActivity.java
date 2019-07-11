package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.CreateTournamentController;
import com.example.tournaments.dataAcces.models.Sport;
import com.example.tournaments.dataAcces.repositories.SportRepository;
import com.example.tournaments.dataAcces.repositories.TypeRepository;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class CreateTournamentActivity extends AppCompatActivity {
    private EditText t_name;
    private EditText t_type;
    private EditText t_teamnumber;
    private EditText t_sport;
    private Button btn_create;
    private ImageView bcancelNew;
    private CreateTournamentController createTournamentController;
    private SportRepository sportRepository;
    private TypeRepository typeRepository;

    //private CreateTournamentController newtourController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_create_tournament);

        t_name = (EditText) findViewById(R.id.t_name);
        t_type = (EditText) findViewById(R.id.t_type);
        t_teamnumber = (EditText) findViewById(R.id.t_teamnumber);
        t_sport = (EditText) findViewById(R.id.t_sport);
        btn_create = (Button) findViewById(R.id.btn_create);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTournamentController = new CreateTournamentController();
                sportRepository = new SportRepository();
                typeRepository = new TypeRepository();
                String name = t_name.getText().toString();
                String sportname = t_sport.getText().toString();
                String tournamentType = t_type.getText().toString();
                int numberOfTeams = Integer.parseInt(t_teamnumber.getText().toString());

                try{
                    boolean message = createTournamentController.createTournament( 1, name , 1, sportRepository.getSportByName(sportname).getId(), typeRepository.getTournament_TypeByName(tournamentType).getId(),numberOfTeams);
                    Intent intent = new Intent(CreateTournamentActivity.this, AdminHomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "The tournament was created", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "The tournament could not be created.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ImageView bcancelNew = (ImageView) findViewById(R.id.bcancelNew);
        bcancelNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTournamentActivity.this, AdminHomeActivity.class);
                startActivity(intent);

            }
        });

    }
}
