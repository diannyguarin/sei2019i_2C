package com.example.tournaments.Presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TournamentsAdapter;
import com.example.tournaments.businessLogic.Controllers.PopulateTournamentListController;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.models.User_tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import com.example.tournaments.dataAcces.repositories.UserRepository;
import com.example.tournaments.dataAcces.repositories.User_tournamentRepository;

import java.util.ArrayList;

public class MyTournamentsActivity  extends Prueba {

    ListView listView;
    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    private PopulateTournamentListController populateTournamentListController;
    private UserRepository userRepository;
    private User_tournamentRepository user_tournamentRepository;
    private ArrayList<Tournament> tournaments = new ArrayList<>();
    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_my_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tournament list");
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");


        listView = (ListView) findViewById(R.id.list);
        populateTournamentList();
        deleteItem_Clik();
    }

    public ArrayList<Tournament> getTournaments(){
        user_tournamentRepository = new User_tournamentRepository();
        tournamentRepository = new TournamentRepository();
        try{

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prro", Toast.LENGTH_SHORT).show();
        }
        return tournaments;
    }

    // Cambio

    public void populateTournamentList(){
        populateTournamentListController = new PopulateTournamentListController();
        TournamentsAdapter tournamentsAdapter = new TournamentsAdapter(MyTournamentsActivity.this, populateTournamentListController.getTournaments());
        listView.setAdapter(tournamentsAdapter);
    }

    private void deleteItem_Clik() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, final int position, long l) {
                Intent intent3 = new Intent();
                intent3.putExtra("currentUser", currentUsername);
                final TournamentsAdapter tournamentsAdapter2 = new TournamentsAdapter(MyTournamentsActivity.this, getTournaments());
                listView.setAdapter(tournamentsAdapter2);

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MyTournamentsActivity.this);
                dialogo1.setTitle("Important");
                dialogo1.setMessage("Â¿ You want to eliminate this tournament ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        try{
                            Intent intent3 = new Intent();
                            intent3.putExtra("currentUser", currentUsername);
                            //Object toRemove =  tournamentsAdapter2.getItem(position);
                            //tournamentsAdapter2.remove();
                            //tournamentRepository.deleteTournamentById((int) tournamentsAdapter2.getItem(position).getId_torneo());
                            user_tournamentRepository = new User_tournamentRepository();
                            userRepository = new UserRepository();
                            user_tournamentRepository.createUser_tournament(userRepository.getUserByUsername(currentUsername).getName(),userRepository.getUserByUsername(currentUsername).getId(),(int) tournamentsAdapter2.getItem(position).getId_torneo());
                            tournamentsAdapter2.notifyDataSetChanged();
                            Toast.makeText(getApplicationContext(), "Torneo Borrado", Toast.LENGTH_SHORT).show();
                        }catch(Exception e){
                            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialogo1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();
                return false;
            }
        });
    }
}
