package com.example.tournaments.dataAcces.databases;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AsyncQuery extends AsyncTask<String,Void, ArrayList<String>> {
    private Connection connect;
    private Statement statement = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet ;
    private int type;

    public AsyncQuery(int type) {
        this.connect = null;
        this.preparedStatement = null;
        this.resultSet = null;
        this.type = type;
    }

    @Override
    protected ArrayList<String> doInBackground(String... strings) {
        ArrayList<String> results=new ArrayList<>();
        try {
            Class.forName(SQLHelper.driver);

            String username = SQLHelper.usr;
            String password = SQLHelper.pwd;
            String url = SQLHelper.url;
            String query=strings[0];
            connect = DriverManager.getConnection(url, username, password);
            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int size = preparedStatement.getFetchSize();
            if(type == 1){
                while (resultSet.next()) {
                    results.add(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
                }
            }else{
                while (resultSet.next()) {
                    results.add(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
                }
            }


        } catch (ClassNotFoundException | SQLException e) {
            Log.e("error: ", e.getMessage());
        } finally {
            close();
        }
        return results;
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
