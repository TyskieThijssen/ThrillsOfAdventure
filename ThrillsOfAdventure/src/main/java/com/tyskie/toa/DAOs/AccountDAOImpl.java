package com.tyskie.toa.DAOs;

import com.tyskie.toa.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tyskie on 4/1/17.
 */
public class AccountDAOImpl implements AccountDAO{
    DatabaseConnection connection = new DatabaseConnection();
    Connection conn = connection.getConnection();
    PreparedStatement preparedStatement;
    String query;

    @Override
    public boolean checkIfAccountExists(String username, String password) {
        boolean exists = false;
        try{
            query = "SELECT * FROM Account WHERE username = ? AND password = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public void registerAccount(String username, String password) {
        try{
            query = "INSERT INTO Account VALUES (?, ?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
