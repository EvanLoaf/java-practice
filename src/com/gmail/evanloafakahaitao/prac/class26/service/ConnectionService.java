package com.gmail.evanloafakahaitao.prac.class26.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private Connection connection = null;

    private ConnectionService() {}

    private static class Holder {
        private static ConnectionService connectionService = new ConnectionService();
    }

    public static ConnectionService getInstance() {
        return Holder.connectionService;
    }

    public Connection getConnection() {
        try {
            /*if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/office?autoReconnect=true&useSSL=false", "root", "root"
                );
            }*/
            /*Class.forName("com.mysql.jdbc.Driver");*/
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/office?autoReconnect=true&useSSL=false", "root", "root"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
