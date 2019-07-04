package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText name_Text;
    EditText passw_Text;
    Button login_Button;
    TextView reg_Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Elementos en la GUI
        name_Text = (EditText) findViewById(R.id.etName);//Texto Nombre
        passw_Text = (EditText) findViewById(R.id.etPassword);//Texto Password
        login_Button = (Button) findViewById(R.id.bLogin);//Boton Login
        reg_Text = (TextView) findViewById(R.id.tregister);//Texto registrarse

        reg_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VER BASE DE DATOS CON LO QUE INGRESO EL USUARIO
                //String query= "select id_sistema,contraseña from user where id_sistema = "+name_Text.getText().toString()+" and password = "+passw_Text.getText().toString()+"";
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
    /** Called when the user taps the Registrarse button */


}
