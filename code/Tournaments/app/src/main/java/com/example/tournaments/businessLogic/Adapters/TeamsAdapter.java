package com.example.tournaments.businessLogic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.Tournament;

import java.util.ArrayList;

public class TeamsAdapter extends BaseAdapter {

    Context context;
    ArrayList<Team> teams = new ArrayList<>();

    public TeamsAdapter(Context context, ArrayList<Team> tournaments){
        this.context = context;
        this.teams = teams;
    }

    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.team_list, parent, false);
        }

        Tournament tempTournament = (Tournament) getItem(position);

        TextView tvName = (TextView)convertView.findViewById(R.id.tvName);


        tvName.setText(tempTournament.getName());

        return convertView;
    }
}
