package com.example.tournaments.Presentation;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Tournament;
import com.example.tournaments.dataAcces.repositories.TournamentRepository;
import java.util.ArrayList;
import java.util.Iterator;

public class ListActivity extends AppCompatActivity {

    Button btn_deletetour;
    ListView ListView_tour;
    TextView tName, tSport;
    private TournamentRepository tournamentRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_tournaments);
        ListView_tour = (ListView) findViewById(R.id.ListView_tour);

        tournamentRepository = new TournamentRepository();
        ArrayList tours = tournamentRepository.getAllTournaments();
        ArrayAdapter adapter2 = new ArrayAdapter(ListActivity.this,R.layout.formato_fila,tours);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,android.R.layout.simple_list_item_1,tours);
        ListView_tour.setAdapter(adapter2);
        
    }
}

