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
import com.example.tournaments.dataAcces.models.User;

import java.io.Serializable;

public class LoginActivity extends AppCompatActivity {

    private LoginController loginController;
    private EditText etUsername;
    private EditText etPassword;
    private CheckBox checkBox;
    User userstore = new User();
    Administrator adminstore = new Administrator();

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
                if(checkBox.isChecked()){
                    try{
                        adminstore = loginController.loginAdmin(username, pass);
                        Intent intent = new Intent(LoginActivity.this, AdminHomeActivity.class);
                        startActivity(intent);
                        finish();
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "The data you have entered is not correct.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    try{
                        userstore = loginController.loginUser(username, pass);
                        Intent intent = new Intent(LoginActivity.this, UserUpdateDataActivity.class);
                        intent.putExtra("currentUser", userstore.getUsername());
                        startActivity(intent);
                        finish();
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "The data you have entered is not correct.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button btn_gotosignup = (Button) findViewById(R.id.btn_gotosignup);
        btn_gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });


    }
























        /*if (android.os.Build.VERSION.SDK_INT > 27) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {

            //boolean updateuser = user.updateUser("WHAT","THE", "FUCK?");
            //boolean updateadmin = admin.updateAdmin("qwerty", "231654");
            User usergotten = user.getUserByUsername("-");
            Administrator admingotten = admin.getAdminByUsername("qwerty");

            Toast.makeText(getApplicationContext(), ""+usergotten+" "+admingotten, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "" + e,Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }*/
    }



