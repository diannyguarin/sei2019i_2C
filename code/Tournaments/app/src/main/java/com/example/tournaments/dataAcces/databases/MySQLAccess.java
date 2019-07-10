package com.example.tournaments.dataAcces.databases;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess extends AsyncTask<String,Void, Boolean> {
    private Connection connect;
    private Statement statement = null;
    private ResultSet resultSet ;

    public MySQLAccess() {
        this.connect = null;
        this.resultSet = null;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        boolean control=false;
        try {
            Class.forName(SQLHelper.driver);

            String username = SQLHelper.usr;
            String password = SQLHelper.pwd;
            String url = SQLHelper.url;
            connect = DriverManager.getConnection(url, username, password);
            control=true;
        } catch (ClassNotFoundException | SQLException e) {
            Log.e("error: ", e.getMessage());
        } finally {
            close();
        }
        return control;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            Log.e("error de close",e.getMessage());
        }
    }
}
