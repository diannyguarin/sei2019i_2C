package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Adapters.TeamsAdapter;
import com.example.tournaments.businessLogic.Controllers.PopulateTeamListController;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class BracketsActivity extends Prueba implements AdapterView.OnItemSelectedListener {
private PopulateTeamListController popTeam;
    private TeamRepository teamRepository;
    private ArrayList<String> teamNames;
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<String> teamsAux ;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_brackets);

        teamNames= new ArrayList<String>();
        teamsAux= new ArrayList<String>();
        teams = getTeams();

        FloatingActionButton next= findViewById(R.id.fab);
        next = (FloatingActionButton) findViewById(R.id.fabNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BracketsActivity.this, SelectTeamsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Iterator<Team> iter = teams.iterator();
        while (iter.hasNext()) {
            String s = iter.next().getName();
            teamNames.add(s);
            teamsAux.add(s);
        }
        //teamsAux.addAll(teamNames);
        //listView = (ListView) findViewById(R.id.list);

         Spinner spinTourType =  findViewById(R.id.spinner);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,teamNames);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTourType.setAdapter(adapter1);
        spinTourType.setOnItemSelectedListener(this);
        //spinTourType.setSelection(0);
    }

    public ArrayList<Team> getTeams(){
        teamRepository = new TeamRepository();
        try{
            teams = teamRepository.getAllTeams();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Paila prro", Toast.LENGTH_SHORT).show();
        }
        return teams;
    }

    public void populateTeamList(){
        TeamsAdapter teamsAdapter = new TeamsAdapter(BracketsActivity.this, getTeams());
        listView.setAdapter(teamsAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        ArrayList<String> newTeams = new ArrayList<String>();
        Iterator<String> iter = teamsAux.iterator();

        while (iter.hasNext()) {

            String s;
            if(!(s = iter.next()).equals(item)){
                newTeams.add(s);
            }

        }

        Spinner spin2 =  findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,newTeams);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);

        Spinner spin3 =  findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,newTeams);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter2);

        Spinner spin4 =  findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,newTeams);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(adapter2);

        Spinner spin5 =  findViewById(R.id.spinner5);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,newTeams);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(adapter2);

        Spinner spin6 =  findViewById(R.id.spinner6);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,newTeams);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin6.setAdapter(adapter2);

        Spinner spin7 =  findViewById(R.id.spinner7);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,newTeams);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin7.setAdapter(adapter2);

        Spinner spin8 =  findViewById(R.id.spinner8);
        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(BracketsActivity.this,
                android.R.layout.simple_list_item_1,newTeams);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin8.setAdapter(adapter2);
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
