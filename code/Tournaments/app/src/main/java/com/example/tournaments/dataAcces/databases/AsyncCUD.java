package com.example.tournaments.dataAcces.databases;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AsyncCUD extends AsyncTask<String,Void,Boolean> {
    private Connection connect;
    private Statement statement = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet ;

    public AsyncCUD() {
        this.connect = null;
        this.preparedStatement = null;
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
            String query=strings[0];
            connect = DriverManager.getConnection(url, username, password);
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.execute();
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
