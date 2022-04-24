package com.gmail.evanloafakahaitao.hwk.hwk25.service;

import com.gmail.evanloafakahaitao.hwk.hwk25.connection.ConnectionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {

    public static void createDatabase() {
        String sql = "create database if not exists library;";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
             System.out.println(e.getMessage());
        }
    }

    public static void createBooksTable() {
        String sql = "create table if not exists books(id serial primary key, " +
                "title varchar(40) not null, " +
                "client_id bigint(20) unsigned null, " +
                "foreign key (client_id) references clients (id) on update cascade on delete set null);";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void createClientsTable() {
        String sql = "create table if not exists clients(id serial primary key, " +
                "name varchar(40) not null);";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
