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

public class Tournaments_admin_Adapter extends BaseAdapter {

    Context context;
    ArrayList<Tournament> tournaments = new ArrayList<>();

    public Tournaments_admin_Adapter(Context context, ArrayList<Tournament> tournaments){
        this.context = context;
        this.tournaments = tournaments;
    }

    @Override
    public int getCount() {
        return tournaments.size();
    }

    @Override
    public Tournament getItem(int position) {
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

        Tournament tempTournament = (Tournament) getItem(position);

        TextView tvName2 = (TextView)convertView.findViewById(R.id.tvName2);
        TextView tvSport2 = (TextView)convertView.findViewById(R.id.tvSport2);
        TextView tvTType2 = (TextView)convertView.findViewById(R.id.tvTType2);
        TextView tvNTeams2 = (TextView)convertView.findViewById(R.id.tvNTeams2);

        tvName2.setText(tempTournament.getName());
        if(tempTournament.getSport()==1){
            tvSport2.setText("Football");
        }
        if(tempTournament.getType()==1){
            tvTType2.setText("Knockout");
        }
        tvNTeams2.setText(""+tempTournament.getNumberOfTeams()+" Teams");

        return convertView;
    }
}
