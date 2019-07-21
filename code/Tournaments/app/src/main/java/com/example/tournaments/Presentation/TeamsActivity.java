package com.example.tournaments.Presentation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TeamsAdapter;
import com.example.tournaments.businessLogic.Controllers.CreateTournamentController;
import com.example.tournaments.businessLogic.Controllers.CreateTeamController;
import com.example.tournaments.businessLogic.Controllers.UpdateController;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.repositories.TeamRepository;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import com.example.tournaments.dataAcces.repositories.UserRepository;


import java.util.ArrayList;

public class TeamsActivity extends Prueba{
    ListView listView;
    private TeamRepository teamRepository;
    private Team team;
    private ArrayList<Team> teams = new ArrayList<>();
    private UserRepository userRepository;
    private CreateTeamController createTeamController;
    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_teams);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Teams");
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");

        FloatingActionButton fab = findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        });*/
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertNewTeam();
            }
        });

        listView = (ListView) findViewById(R.id.list);
        populateTeamList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                team = teams.get(team.getId());
                Intent intent4 = new Intent(view.getContext(), TournamentActivity.class);
                intent4.putExtra("currentUser", currentUsername);
                startActivity(intent4);
                finish();
            }
        });
    }

    public ArrayList<Team> getTeams(){
        teamRepository = new TeamRepository();
        try{
            teams = teamRepository.getAllTeams();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prro", Toast.LENGTH_SHORT).show();
        }
        return teams;
    }

    public void populateTeamList(){
        TeamsAdapter teamsAdapter = new TeamsAdapter(TeamsActivity.this, getTeams());
        listView.setAdapter(teamsAdapter);
    }

    public void alertNewTeam(){
        AlertDialog.Builder builder = new AlertDialog.Builder(TeamsActivity.this);
        final View view = LayoutInflater.from(TeamsActivity.this).inflate(R.layout.dialogo_new_team, null);
        builder.setView(view);
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");

        createTeamController = new CreateTeamController();

        userRepository = new UserRepository();


        final EditText edtTitulo = view.findViewById(R.id.edtTitulo);
        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nombre = edtTitulo.getText().toString().trim();

                if (nombre.length()>0){
                    createTeamController.createTeam(nombre, userRepository.getUserByUsername(currentUsername).getId());
                    Toast.makeText(getApplicationContext(),"Sucessfull", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplicationContext(),"Error name Team", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

/*

        public boolean createTeam(String name, int user){
            boolean success = false;
            try{
                teamRepository = new TeamRepository();
                success = teamRepository.createTeam(name, user);
            }catch(Exception e){
                return false;
            }
            return success;
        }
*/

}
