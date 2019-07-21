package com.example.tournaments.Presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TournamentsAdapter;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;

import java.util.ArrayList;

public class UserHomeListActivity extends Prueba {

    ListView listView;
    private TournamentRepository tournamentRepository;
    private Tournament tournament;
    private ArrayList<Tournament> tournaments = new ArrayList<>();
    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tournament list");
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");

        Button bBackHome = (Button) findViewById(R.id.bBackHome);
        bBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent3 = new Intent(UserHomeListActivity.this, UserHomeActivity.class);
                    intent3.putExtra("currentUser", currentUsername);
                    startActivity(intent3);
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }

            }});
        listView = (ListView) findViewById(R.id.list);
        populateTournamentList();
        //selectItem_Clik();
        deleteItem_Clik();


    }

    public ArrayList<Tournament> getTournaments(){
        tournamentRepository = new TournamentRepository();
        try{
            tournaments = tournamentRepository.getAllTournaments();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prro", Toast.LENGTH_SHORT).show();
        }
        return tournaments;
    }

    public void populateTournamentList(){
        TournamentsAdapter tournamentsAdapter = new TournamentsAdapter(UserHomeListActivity.this, getTournaments());
        listView.setAdapter(tournamentsAdapter);
    }

    private void selectItem_Clik(){

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                try{
                    Intent intent3 = new Intent(UserHomeListActivity.this, UserHomeActivity.class);
                    intent3.putExtra("currentUser", currentUsername);
                    startActivity(intent3);
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
                /*Toast.makeText(getApplicationContext(),"Pulsaste el elemento"+ String.valueOf(position)+ "de la lista ", Toast.LENGTH_SHORT).show(); */           }
        });

    }

    private void deleteItem_Clik() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, final int position, long l) {
                Intent intent3 = new Intent();
                intent3.putExtra("currentUser", currentUsername);
                final TournamentsAdapter tournamentsAdapter2 = new TournamentsAdapter(UserHomeListActivity.this, getTournaments());
                listView.setAdapter(tournamentsAdapter2);

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(UserHomeListActivity.this);
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
                            tournamentRepository.deleteTournamentById((int) tournamentsAdapter2.getItem(position).getId_torneo());
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



