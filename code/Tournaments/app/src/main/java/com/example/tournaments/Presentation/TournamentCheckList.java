package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.example.tournaments.R;

public class TournamentCheckList extends Prueba{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tournaments_check);

        FloatingActionButton next= findViewById(R.id.fab);
        next = (FloatingActionButton) findViewById(R.id.fabNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TournamentCheckList.this, BracketsActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


}
