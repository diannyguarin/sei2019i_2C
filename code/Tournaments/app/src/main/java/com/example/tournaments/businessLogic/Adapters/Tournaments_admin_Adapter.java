package com.example.tournaments.businessLogic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.TempTournamentTeamData;
import com.example.tournaments.dataAcces.models.TempUserTournamentData;
import com.example.tournaments.dataAcces.models.Tournament;

import java.util.ArrayList;

public class Tournaments_admin_Adapter extends BaseAdapter {

    Context context;
    ArrayList<TempUserTournamentData> tournaments = new ArrayList<>();

    public Tournaments_admin_Adapter(Context context, ArrayList<TempUserTournamentData> tournaments){
        this.context = context;
        this.tournaments = tournaments;
    }

    @Override
    public int getCount() {
        return tournaments.size();
    }

    @Override
    public TempUserTournamentData getItem(int position) {
        return tournaments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.tournament_admin_list, parent, false);
        }

        TempUserTournamentData tempTournament = getItem(position);

        TextView tvName2 = (TextView)convertView.findViewById(R.id.tvName2);
        TextView tvSport2 = (TextView)convertView.findViewById(R.id.tvSport2);
        TextView tvTType2 = (TextView)convertView.findViewById(R.id.tvTType2);
        TextView tvNTeams2 = (TextView)convertView.findViewById(R.id.tvNTeams2);

        tvName2.setText(tempTournament.getName());
        tvSport2.setText("Football");
        tvTType2.setText("Knockout");
        tvNTeams2.setText(""+tempTournament.getNumberOfteams()+" Teams");

        return convertView;
    }
}
