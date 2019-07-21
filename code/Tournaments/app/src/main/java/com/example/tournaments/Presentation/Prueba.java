package com.example.tournaments.Presentation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;

import com.example.tournaments.R;

public class Prueba extends AppCompatActivity{

    String currentUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.commonmenu,menu);
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
            Intent intent = new Intent(Prueba.this, UserHomeListActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
        }else
        if (id==R.id.menuTournaments){
            //ver lista de torneos disponibles
            Toast.makeText(this, "Tournaments menu is cliked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Prueba.this, MyTournamentsActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
        }else
        if (id==R.id.menuTeams){
            //ver lista de torneos disponibles
            Toast.makeText(this, "Teams menu is cliked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Prueba.this, TeamsActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
        }else
        if (id==R.id.menuUpdate){
            //ver lista de torneos disponibles
            Toast.makeText(this, "Update menu is cliked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Prueba.this, UserUpdateDataActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
        }else
        if (id==R.id.menuLogout){
            //ver lista de torneos disponibles
            Toast.makeText(this, "Bye Bye", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Prueba.this, LoginActivity.class);
            intent.putExtra("currentUser", currentUsername);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }




}
