package com.example.tournaments.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tournaments.R;

public class AdminHomeActivity extends AppCompatActivity {

    private TextView tv_role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        tv_role = (TextView) findViewById(R.id.tv_role);

    }
}
