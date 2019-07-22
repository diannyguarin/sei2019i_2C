package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.CreateTournamentController;
import com.example.tournaments.dataAcces.models.Sport;
import com.example.tournaments.dataAcces.repositories.SportRepository;
import com.example.tournaments.dataAcces.repositories.TypeRepository;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class CreateTournamentActivity extends Prueba2  {
    private EditText t_name;
    private EditText t_type;
    private EditText t_teamnumber;
    private EditText t_sport;
    private Button btn_create;
    private ImageView bcancelNew;
    private CreateTournamentController createTournamentController;
    private SportRepository sportRepository;
    private TypeRepository typeRepository;
    private int sport;
    private int tournType;


    //private CreateTournamentController newtourController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_create_tournament);


        //Tournament Type Spinner
         final Spinner spinTourType =  findViewById(R.id.stourType);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(CreateTournamentActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.tourType));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTourType.setAdapter(adapter1);

        //Tournament Number of Teams Spinner
         final Spinner spinNumberTeams = findViewById(R.id.spinnerTeams);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(CreateTournamentActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.TeamNumber));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinNumberTeams.setAdapter(adapter2);

        //Tournament Number of Teams Spinner
         final Spinner spinSport = findViewById(R.id.sSport);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(CreateTournamentActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sportName));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSport.setAdapter(adapter3);

        //Bundle extras = this.getIntent().getExtras();

        //currentUsername = extras.getString("currentUser");

        //spinNumberTeams.setOnItemSelectedListener(this);

        t_name = (EditText) findViewById(R.id.t_name);
       // t_type = (EditText) findViewById(R.id.t_type);
        //t_teamnumber = (EditText) findViewById(R.id.t_teamnumber);
        //t_sport = (EditText) findViewById(R.id.t_sport);
        btn_create = (Button) findViewById(R.id.btn_create);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTournamentController = new CreateTournamentController();
                sportRepository = new SportRepository();
                typeRepository = new TypeRepository();
                String name = t_name.getText().toString();
                String sportname = spinSport.getSelectedItem().toString();
                String tournamentType = spinTourType.getSelectedItem().toString();
                String numberOfTeams = spinNumberTeams.getSelectedItem().toString();

                if(name.equals("") || sportname.equals("") || tournamentType.equals("") || numberOfTeams.equals("")){
                    Toast.makeText(getApplicationContext(), "All fields must be filled.", Toast.LENGTH_SHORT).show();
                }else{
                    if(tournamentType.equals("Knockout")){
                        sport = 1;
                        int numberOfTeamsInt = Integer.parseInt(numberOfTeams);
                        if(numberOfTeamsInt == 2 || numberOfTeamsInt == 4 || numberOfTeamsInt == 8 || numberOfTeamsInt == 16){
                            if(sportname.equals("Football")){
                                tournType = 1;
                                try{
                                    boolean message = createTournamentController.createTournament(name, sport, tournType, numberOfTeamsInt);
                                    if(message == true){
                                        cleanForm();
                                        Toast.makeText(getApplicationContext(), "Tournament created successfully.", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(getApplicationContext(), "The tournament could not be created.", Toast.LENGTH_SHORT).show();
                                    }
                                }catch (Exception e){
                                    Toast.makeText(getApplicationContext(), "The tournament could not be created.", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "The sport you entered does not exist.", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "The number of teams is not valid.\nOptions: 2-4-8-16", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "The type of tournament you entered does not exist.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            private void cleanForm(){
                t_name.setText("");
                t_teamnumber.setText("");
                t_type.setText("");
                t_sport.setText("");
            }


        });

    }


}
