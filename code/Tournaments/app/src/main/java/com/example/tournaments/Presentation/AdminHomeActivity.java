package com.example.tournaments.Presentation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tournaments.R;

public class AdminHomeActivity extends AppCompatActivity {

    private TextView tv_role;
    FloatingActionButton newT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        tv_role = (TextView) findViewById(R.id.tv_role);

        newT = (FloatingActionButton) findViewById(R.id.newTour);
        newT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, CreateTournamentActivity.class);
                startActivity(intent);
            }
        });
    }
}
