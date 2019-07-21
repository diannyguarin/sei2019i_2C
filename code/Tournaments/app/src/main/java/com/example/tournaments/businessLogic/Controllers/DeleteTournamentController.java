package com.example.tournaments.businessLogic.Controllers;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;

public class DeleteTournamentController {
   /* private TournamentRepository tourRepo;
    private Tournament tour;
    EditText et;
    Button btnActualizar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_miembro);

        et = (EditText) findViewById(R.id.et_miembro_id);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            /*case R.id.btnActualizar:
                String memName_upd = et.getText().toString();
                tourRepo = new TournamentRepository();
                tourRepo.updateTournament();

                this.returnHome();
                break;
*//*
            case R.id.btnEliminar:
                tourRepo = new TournamentRepository();
                tourRepo.delateTournament();
                this.returnHome();
                break;
        }
    }

    public void returnHome() {

        Intent home_intent = new Intent(getApplicationContext(),
                UserHomeListActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(home_intent);
    }*/
}
