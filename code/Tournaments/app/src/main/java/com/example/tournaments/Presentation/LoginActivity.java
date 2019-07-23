package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.CreateMatchupsController;
import com.example.tournaments.businessLogic.Controllers.CreateUserTournamentController;
import com.example.tournaments.businessLogic.Controllers.LoginController;
import com.example.tournaments.businessLogic.Controllers.PopulateMyTournamentsListController;
import com.example.tournaments.businessLogic.Controllers.PopulateUserTournamentTeamListController;
import com.example.tournaments.dataAcces.models.Administrator;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.TempTournamentTeamData;
import com.example.tournaments.dataAcces.models.TempUserTournamentData;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.models.User_tournament;
import com.example.tournaments.dataAcces.repositories.TeamRepository;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import com.example.tournaments.dataAcces.repositories.User_tournament_teamRepository;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private LoginController loginController;
    private EditText etUsername;
    private EditText etPassword;
    private CheckBox checkBox;
    User userstore = new User();
    Administrator adminstore = new Administrator();

    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    private ArrayList<Tournament> tournaments;

    public User getUserstore() {
        return userstore;
    }

    public void setUserstore(User userstore) {
        this.userstore = userstore;
    }

    public Administrator getAdminstore() {
        return adminstore;
    }

    public void setAdminstore(Administrator adminstore) {
        this.adminstore = adminstore;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tournaments");

        Button btn_gotosignup = (Button) findViewById(R.id.btn_gotosingup);
        btn_gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        Button btn_login = findViewById(R.id.bLogin);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController = new LoginController();
                String username = etUsername.getText().toString();
                String pass = etPassword.getText().toString();


                if (checkBox.isChecked()) {
                    try {
                        adminstore = loginController.loginAdmin(username, pass);
                        Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                        intent.putExtra("currentUser", adminstore.getUsername());
                        startActivity(intent);
                        finish();

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "The data you have entered is not correct.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        userstore = loginController.loginUser(username, pass);
                        Intent intent = new Intent(LoginActivity.this, UserHomeListActivity.class);
                        intent.putExtra("currentUser", userstore.getUsername());
                        intent.putExtra("currentUserId", userstore.getId());
                        startActivity(intent);
                        finish();

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "The data you have entered is not correct.", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

        //testingMyTournamentsList();
        //testingCreateUserTournament();
        //testingUserTournamentTeamList();
        //testingCreateMatchups();
    }

    private void testingCreateMatchups() {
        User_tournament_teamRepository userTournamentTeamRepository = new User_tournament_teamRepository();
        ArrayList<TempTournamentTeamData> tournamentTeamDataArrayList = userTournamentTeamRepository.getAllUserTournamentTeamsImproved(29);
        CreateMatchupsController createMatchupsController = new CreateMatchupsController();
        createMatchupsController.createMatchups(tournamentTeamDataArrayList);
    }

    private void testingUserTournamentTeamList() {
        PopulateUserTournamentTeamListController populateUserTournamentTeamListController = new PopulateUserTournamentTeamListController();
        try{
            ArrayList<TempTournamentTeamData> tempTournamentTeamDataArrayList = populateUserTournamentTeamListController.getAllUserTournamentTeams(29);
            if (tempTournamentTeamDataArrayList == null){
                Toast.makeText(getApplicationContext(), "NULL", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), ""+tempTournamentTeamDataArrayList+" "+tempTournamentTeamDataArrayList.size(), Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prrito, no se pudo hacer esa mrda", Toast.LENGTH_SHORT).show();
        }
    }

    private void testingCreateUserTournament() {
        User_tournament userTournament;
        TeamRepository teamRepository = new TeamRepository();
        ArrayList<Team> teamArrayList = teamRepository.getAllTeamsByUserId(3);
        CreateUserTournamentController createUserTournamentController = new CreateUserTournamentController();
        userTournament = createUserTournamentController.createUserTournament(3, 26, teamArrayList);
        Toast.makeText(getApplicationContext(), ""+userTournament, Toast.LENGTH_SHORT).show();
    }

    public void testingMyTournamentsList(){
        PopulateMyTournamentsListController populateMyTournamentsListController = new PopulateMyTournamentsListController();
        try{
            ArrayList<TempUserTournamentData> tempUserTournamentDataArrayList = populateMyTournamentsListController.getAllUserTournaments(3);
            if (tempUserTournamentDataArrayList == null){
                Toast.makeText(getApplicationContext(), "NULL", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), ""+tempUserTournamentDataArrayList, Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prrito, no se pudo hacer esa mrda", Toast.LENGTH_SHORT).show();
        }
    }

}



