package com.example.tournaments.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;

import com.example.tournaments.R;

public class Prueba2 extends AppCompatActivity{

    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.commonmenu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Bundle extras = this.getIntent().getExtras();
        currentUsername = extras.getString("currentUser");
        int id = item.getItemId();
        if (id==R.id.menuHome){
            //ver lista de torneos disponibles
            Toast.makeText(this, "Home menu is cliked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Prueba2.this, AdminHomeActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
            finish();
        }else
        if (id==R.id.menuCreateTournaments){
            //ver lista de torneos disponibles
            Toast.makeText(this, "Tournaments menu is cliked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Prueba2.this, CreateTournamentActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
            finish();
        }else
        if (id==R.id.menuLogout){
            //ver lista de torneos disponibles
            Toast.makeText(this, "Bye Bye", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Prueba2.this, LoginActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
