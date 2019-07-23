package com.example.tournaments.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.SignupController;

public class SignupActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_username;
    private EditText et_password;
    private EditText et_password2;
    private SignupController signupController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        et_name = (EditText) findViewById(R.id.et_name);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password2 = (EditText) findViewById(R.id.et_password2);

        Button btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupController = new SignupController();
                String name = et_name.getText().toString();
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (et_password.getText().toString().equals(et_password2.getText().toString())) {

                    try {
                        String message = signupController.signUp(name, username, password);
                        Toast.makeText(getApplicationContext(), "" + message, Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "The user could not be created.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "The user could not be created.", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

        ImageView bcancelReg = (ImageView) findViewById(R.id.bcancelReg);
        bcancelReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

}

