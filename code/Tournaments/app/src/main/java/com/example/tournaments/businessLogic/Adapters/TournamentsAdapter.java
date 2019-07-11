package com.example.tournaments.businessLogic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Tournament;

import java.util.ArrayList;

public class TournamentsAdapter extends BaseAdapter {

    Context context;
    ArrayList<Tournament> tournaments = new ArrayList<>();

    public TournamentsAdapter(Context context, ArrayList<Tournament> tournaments){
        this.context = context;
        this.tournaments = tournaments;
    }

    @Override
    public int getCount() {
        return tournaments.size();
    }

    @Override
    public Object getItem(int position) {
        return tournaments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.tournament_list, parent, false);
        }

        Tournament tempTournament = (Tournament) getItem(position);

        TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
        TextView tvSport = (TextView)convertView.findViewById(R.id.tvSport);
        TextView tvTType = (TextView)convertView.findViewById(R.id.tvTType);
        TextView tvNTeams = (TextView)convertView.findViewById(R.id.tvNTeams);

        tvName.setText(tempTournament.getName());
        if(tempTournament.getSport()==1){
            tvSport.setText("Football");
        }
        if(tempTournament.getType()==1){
            tvTType.setText("Knockout");
        }
        tvNTeams.setText(""+tempTournament.getNumberOfTeams()+" Teams");

        return convertView;
    }
}
