package com.example.tournaments.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
    private Connection connect = null;
    private final Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("1");
            // Setup the connection with the DB
            String username = "pwEIUN4GpK";
            String password = "mu0QblJ1yx";
            String url = "jdbc:mysql://www.remotemysql.com:3306/pwEIUN4GpK?connectTimeout=3000";
            connect = DriverManager
                    .getConnection(url, username, password);
            System.out.println("2");


            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  pwEIUN4GpK.Administrator(username,password) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, "qwerty");
            preparedStatement.setString(2, "123456");
            preparedStatement.executeUpdate();
            System.out.println("3");

            preparedStatement = connect
                    .prepareStatement("SELECT * from pwEIUN4GpK.Administrator");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);
            System.out.println("4");

            // Remove again the insert comment
            preparedStatement = connect
            .prepareStatement("delete from pwEIUN4GpK.Administrator where id= ? ; ");
            preparedStatement.setString(1, "1");
            preparedStatement.executeUpdate();

            resultSet = statement
            .executeQuery("select * pwEIUN4GpK.Administrator");
            writeMetaData(resultSet);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("id: " + id);
            System.out.println("username: " + username);
            System.out.println("password: " + password);
        }
    }

    // You need to close the resultSet
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

        }
    }

}