/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifound.dao;

/**
 *
 * @author ISHIMWE Ami Paradis
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ifound.model.LostItem;

public class LostItemDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/servlet";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    private static final String INSERT_LOST_ITEM_SQL = "INSERT INTO lost (name, founder, location, date) VALUES (?, ?, ?, ?);";
    private static final String SELECT_LOST_ITEM_BY_ID = "SELECT id, name, founder, location, date FROM lost WHERE id = ?;";
    private static final String SELECT_ALL_LOST_ITEMS = "SELECT * FROM lost;";
    private static final String DELETE_LOST_ITEM_SQL = "DELETE FROM lost WHERE id = ?;";
    private static final String UPDATE_LOST_ITEM_SQL = "UPDATE lost SET name = ?, founder = ?, location = ?, date = ? WHERE id = ?;";

    public LostItemDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertLostItem(LostItem lostItem) throws SQLException {
        System.out.println(INSERT_LOST_ITEM_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOST_ITEM_SQL)) {
            preparedStatement.setString(1, lostItem.getName());
            preparedStatement.setString(2, lostItem.getFounder());
            preparedStatement.setString(3, lostItem.getLocation());
            preparedStatement.setTimestamp(4, lostItem.getDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public LostItem selectLostItem(int id) {
        LostItem lostItem = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOST_ITEM_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String founder = rs.getString("founder");
                String location = rs.getString("location");
                Timestamp date = rs.getTimestamp("date");
                lostItem = new LostItem(id, name, founder, location, date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return lostItem;
    }

    public List<LostItem> selectAllLostItems() {
        List<LostItem> lostItems = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOST_ITEMS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String founder = rs.getString("founder");
                String location = rs.getString("location");
                Timestamp date = rs.getTimestamp("date");
                lostItems.add(new LostItem(id, name, founder, location, date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return lostItems;
    }

    public boolean deleteLostItem(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_LOST_ITEM_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateLostItem(LostItem lostItem) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_LOST_ITEM_SQL)) {
            statement.setString(1, lostItem.getName());
            statement.setString(2, lostItem.getFounder());
            statement.setString(3, lostItem.getLocation());
            statement.setTimestamp(4, lostItem.getDate());
            statement.setInt(5, lostItem.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

