package com.example.tournaments.businessLogic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.example.tournaments.R;
import com.example.tournaments.dataAcces.models.Team;

import java.util.ArrayList;

public class TeamsCheckAdapter extends BaseAdapter {

    Context context;
    ArrayList<Team> teams = new ArrayList<>();

    public TeamsCheckAdapter(Context context, ArrayList<Team> teams){
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
            convertView = LayoutInflater.from(context).inflate(R.layout.teams_check_list, parent, false);
        }

        Team tempTeam = (Team) getItem(position);

        CheckBox CheckedTextView = convertView.findViewById(R.id.CheckedTextView);
        CheckedTextView.setText(tempTeam.getName());
        return convertView;
    }
}
