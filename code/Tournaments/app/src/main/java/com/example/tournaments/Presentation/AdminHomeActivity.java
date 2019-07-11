package com.example.tournaments.Presentation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tournaments.R;

public class AdminHomeActivity extends AppCompatActivity {

    private TextView tv_role;
    private Button btn_listtour;
    FloatingActionButton newT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        tv_role = (TextView) findViewById(R.id.tv_role);
        btn_listtour = (Button) findViewById(R.id.btn_listtour);

        newT = (FloatingActionButton) findViewById(R.id.newTour);
        newT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, CreateTournamentActivity.class);
                startActivity(intent);
            }
        });

        btn_listtour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });


    }
}
