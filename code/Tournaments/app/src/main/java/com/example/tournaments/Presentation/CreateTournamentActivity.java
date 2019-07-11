package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.SignupController;

public class CreateTournamentActivity extends AppCompatActivity {
    private EditText t_name;
    private EditText t_type;
    private EditText t_teamnumber;
    private Button btn_create;
    //private CreateTournamentController newtourController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_create_tournament);

        t_name = (EditText) findViewById(R.id.t_name);
        t_type = (EditText) findViewById(R.id.t_type);
        t_teamnumber = (EditText) findViewById(R.id.t_teamnumber);
        btn_create = (Button) findViewById(R.id.btn_create);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//Insertar en base de datos
                Intent intent = new Intent(getApplicationContext(), AdminHomeActivity.class);
                startActivity(intent);
            }
        });

        ImageView bcancelreg = (ImageView) findViewById(R.id.bcancelReg);
        bcancelreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminHomeActivity.class);
                startActivity(intent);

            }
        });

    }
}
