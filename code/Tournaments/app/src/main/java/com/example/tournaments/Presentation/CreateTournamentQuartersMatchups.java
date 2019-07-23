package com.example.tournaments.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.PopulateTeamListController;
import com.example.tournaments.businessLogic.Controllers.PopulateUserTournamentTeamListController;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.TempTournamentTeamData;
import com.example.tournaments.dataAcces.models.TempUserTournamentData;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateTournamentQuartersMatchups extends AppCompatActivity {
   private TextView B1L, B1V, B2L, B2V, B3L, B3V, B4L, B4V, TITLE, BNumber1, BNumber2, BNumber3, BNumber4;
    ArrayList<TempTournamentTeamData> tournamentTeamDataArrayList = new ArrayList<>();
    ArrayList<TempTournamentTeamData> tournamentTeamDataMatchupArraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament_quarters_matchups);

        Intent intent = getIntent();
        Bundle extras = this.getIntent().getExtras();
        String currentUsername = extras.getString("currentUser");
        String previousActivity = extras.getString("previousActivity");
        final int currentUserId = extras.getInt("currentUserId");
        final int tournamentId = extras.getInt("userTournamentId");
        if (previousActivity.equals("selectTeams")){
            Bundle args = intent.getBundleExtra("BUNDLE");
            tournamentTeamDataArrayList = (ArrayList<TempTournamentTeamData>) args.getSerializable("tournamentTeam");
            tournamentTeamDataMatchupArraylist = (ArrayList<TempTournamentTeamData>) args.getSerializable("tournamentTeamMatchup");
        }


        if(tournamentTeamDataArrayList.isEmpty() && previousActivity.equals("createTournament")){
            PopulateUserTournamentTeamListController populateTeamListController = new PopulateUserTournamentTeamListController();
            tournamentTeamDataArrayList = populateTeamListController.getAllUserTournamentTeams(tournamentId);
        }



        B1L = (TextView) findViewById(R.id.tvb1l);
        B1V = (TextView) findViewById(R.id.tvb1v);
        B2L = (TextView) findViewById(R.id.tvb2l);
        B2V = (TextView) findViewById(R.id.tvb2v);
        B3L = (TextView) findViewById(R.id.tvb3l);
        B3V = (TextView) findViewById(R.id.tvb3v);
        B4L = (TextView) findViewById(R.id.tvb4l);
        B4V = (TextView) findViewById(R.id.tvb4v);
        BNumber1 = (TextView) findViewById(R.id.tvbracketnumber1);
        BNumber2 = (TextView) findViewById(R.id.tvbracketnumber2);
        BNumber3 = (TextView) findViewById(R.id.tvbracketnumber3);
        BNumber4 = (TextView) findViewById(R.id.tvbracketnumber4);
        TITLE = (TextView) findViewById(R.id.tvphase);

        if(tournamentTeamDataMatchupArraylist.isEmpty()){

        }else{
            if(tournamentTeamDataMatchupArraylist.get(0)==null){

            }else{
                B1L.setText(tournamentTeamDataMatchupArraylist.get(0).getName());
            }

        }

        B1L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTournamentQuartersMatchups.this, CreateTournamentSelectTeamsMatchups.class);
                Bundle args = new Bundle();
                args.putSerializable("tournamentTeam",(Serializable)tournamentTeamDataArrayList);
                args.putSerializable("tournamentTeamMatchup",(Serializable)tournamentTeamDataMatchupArraylist);
                intent.putExtra("previousActivity", "selectTeams");
                intent.putExtra("currentUserId", currentUserId);
                intent.putExtra("tournamentId", tournamentId);
                intent.putExtra("bracket", 0);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });

        B1V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTournamentQuartersMatchups.this, CreateTournamentSelectTeamsMatchups.class);
                Bundle args = new Bundle();
                args.putSerializable("tournamentTeam",(Serializable)tournamentTeamDataArrayList);
                args.putSerializable("tournamentTeamMatchup",(Serializable)tournamentTeamDataMatchupArraylist);
                intent.putExtra("previousActivity", "selectTeams");
                intent.putExtra("currentUserId", currentUserId);
                intent.putExtra("tournamentId", tournamentId);
                intent.putExtra("bracket", 1);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });
    }
}
