package com.example.tournaments.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tournaments.BussinesLogic.LoginController;
import com.example.tournaments.R;
import com.example.tournaments.dataAcces.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {
    EditText name_Text;
    EditText passw_Text;
    Button login_Button;
    TextView reg_Text;

    //UserRepository utili=new UserRepository();
    LoginController controller = new LoginController();
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
            public void onClick(View view) {
                if (controller.Login(name_Text.getText().toString(), passw_Text.getText().toString())==true){
                    Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    /** Called when the user taps the Registrarse button */


}
