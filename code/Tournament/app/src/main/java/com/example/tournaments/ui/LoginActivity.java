package com.example.tournaments.ui;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Administrator;
import com.example.tournaments.dataAcces.models.User;
import com.example.tournaments.dataAcces.repositories.AdministratorRepository;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {
    AdministratorRepository admin=new AdministratorRepository();
    UserRepository user=new UserRepository();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (android.os.Build.VERSION.SDK_INT > 27) {
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
        }
    }
}
