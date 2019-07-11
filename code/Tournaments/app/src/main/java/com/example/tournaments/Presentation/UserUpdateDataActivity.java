package com.example.tournaments.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tournaments.R;
import com.example.tournaments.businessLogic.Controllers.SignupController;
import com.example.tournaments.businessLogic.Controllers.UpdateController;
import com.example.tournaments.dataAcces.models.User;

public class UserUpdateDataActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_username;
    private EditText et_password;
    private UpdateController updateController;
    LoginActivity loginActivity;
    String currentUsername;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update_data);

        et_name = (EditText) findViewById(R.id.et_name);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        /*User userLoggedin = new User();
        loginActivity = new LoginActivity();
        userLoggedin = loginActivity.userstore;
        currentUsername = userLoggedin.getUsername();*/

        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");

        Button btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateController = new UpdateController();
                String name = et_name.getText().toString();
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                    try{
                        updateController.updateUser(currentUsername, name, username, password);
                        Toast.makeText(getApplicationContext(), "Let's check!", Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "The user could not be updated.", Toast.LENGTH_SHORT).show();
                    }

               }
            });


        ImageView bexit = (ImageView) findViewById(R.id.bexit);
        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserUpdateDataActivity.this, UserHomeActivity.class);
                intent.putExtra("currentUser", currentUsername);
                startActivity(intent);
            }
        });
        }
}


        /*Button btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateController = new UpdateController();

                String name = et_name.getText().toString();
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                try{
                    updateController.updateUser(currentUsername, name, username, password);
                    Toast.makeText(getApplicationContext(), "Let's check!", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "The user could not be updated.", Toast.LENGTH_SHORT).show();
                }
            }
        });*/