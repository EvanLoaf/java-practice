package com.gmail.evanloafakahaitao.hwk.hwk25.impl;

import com.gmail.evanloafakahaitao.hwk.hwk25.ClientDao;
import com.gmail.evanloafakahaitao.hwk.hwk25.connection.ConnectionService;
import com.gmail.evanloafakahaitao.hwk.hwk25.model.Client;

import java.sql.*;

public class ClientDaoImpl implements ClientDao {

    @Override
    public void save(Client client) {
        String sql = "insert into clients (name) values (?);";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                )) {
                    preparedStatement.setString(1, client.getName());
                    int affectedRows = preparedStatement.executeUpdate();

                    if (affectedRows == 0) {
                        throw new SQLException("Creating CLIENT failed, no rows affected!");
                    }

                    try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            client.setId(resultSet.getLong(1));
                        } else {
                            throw new SQLException("Creating CLIENT failed, no ID returned!");
                        }
                    }
                }
            } else throw new SQLException("No connection!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Client getById(Long id) {
        String sql = "select * from clients where id = ?;";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setLong(1, id);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            return Client.newBuilder()
                                    .withName(resultSet.getString("name"))
                                    .withId(resultSet.getLong("id"))
                                    .build();
                        } else {
                            throw new SQLException("Getting CLIENT by ID failed! No result returned!");
                        }
                    }
                }
            } else throw new SQLException("No connection!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
