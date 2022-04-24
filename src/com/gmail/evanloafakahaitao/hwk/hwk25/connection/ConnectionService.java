package com.gmail.evanloafakahaitao.hwk.hwk25.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private Connection connection;

    private ConnectionService() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false",
                    "root",
                    "root"
            );
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
    }

    private static class Holder {
        private static ConnectionService connectionService = new ConnectionService();
    }

    public static ConnectionService getInstance() {
        return Holder.connectionService;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                System.out.println("Closing connection failed!");
                e.printStackTrace();
            }
        }
    }
}
