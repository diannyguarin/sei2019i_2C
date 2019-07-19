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
import com.example.tournaments.businessLogic.Controllers.LoginController;
import com.example.tournaments.dataAcces.models.Administrator;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;

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
                        startActivity(intent);

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "The data you have entered is not correct.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        userstore = loginController.loginUser(username, pass);
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        intent.putExtra("currentUser", userstore.getUsername());
                        startActivity(intent);

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "The data you have entered is not correct.", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
    }
    }



