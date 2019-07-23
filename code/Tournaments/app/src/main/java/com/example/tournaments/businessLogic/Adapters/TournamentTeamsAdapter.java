package com.example.tournaments.businessLogic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Team;
import com.example.tournaments.dataAcces.models.TempTournamentTeamData;
import com.example.tournaments.dataAcces.models.TempUserTournamentData;

import java.util.ArrayList;

public class TournamentTeamsAdapter extends BaseAdapter {

    Context context;
    ArrayList<TempTournamentTeamData> teams = new ArrayList<>();

    public TournamentTeamsAdapter(Context context, ArrayList<TempTournamentTeamData> teams){
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

    public void remove(int position)
    {
        teams.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.team_list, parent, false);
        }

        TempTournamentTeamData tempTeam = (TempTournamentTeamData) getItem(position);

        TextView tvName = (TextView)convertView.findViewById(R.id.tvName);


        tvName.setText(tempTeam.getName());

        return convertView;
    }
}
