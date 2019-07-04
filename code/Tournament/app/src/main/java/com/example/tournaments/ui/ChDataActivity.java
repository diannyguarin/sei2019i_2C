package com.example.tournaments.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tournaments.R;

public class ChDataActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changedata);



        }
/** Called when the user taps the Cancel button */
public void goBack(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        }

public void regComplete(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
        }
        }