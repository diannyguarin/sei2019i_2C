package com.example.tournaments.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.tournaments.BussinesLogic.ChDataController;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tournaments.R;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class ChDataActivity extends AppCompatActivity {

        ChDataController controller = new ChDataController();
        EditText name;
        EditText nick;
        EditText passw;
        Button updateButton;
        ImageView exitb;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changedata);

        name = (EditText) findViewById(R.id.etName);//Text Name
        nick = (EditText) findViewById(R.id.etUsername);//Text Username
        passw = (EditText) findViewById(R.id.etPassword1);//Text Password

        updateButton = (Button) findViewById(R.id.bUpdate);//Update Button
        exitb = (ImageView) findViewById(R.id.bexit); // Exit Button

        exitb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        // Insertar en base de datos
                        try{
                        controller.updateUser(LoginActivity.name,name.getText().toString(), nick.getText().toString(), passw.getText().toString());
                                Toast.makeText(getApplicationContext(), "Datos cambiados exitosamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                        }catch(Exception e){

                Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
        }
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                }
        });

        }
         /** Called when the user taps the Cancel button */

        }