package com.gmail.evanloafakahaitao.hwk.hwk26.service;

import com.gmail.evanloafakahaitao.hwk.hwk26.connection.ConnectionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {

    public static void createDatabase() {
        String sql = "create database if not exists city;";
        execute(sql);
    }

    public static void createFlatsTable() {
        String sql = "create table if not exists flats(id serial primary key, " +
                "size tinyint(3) unsigned not null, " +
                "count_of_rooms tinyint(2) unsigned not null, " +
                "floor tinyint(2) unsigned not null, " +
                "is_populated bool not null default false, " +
                "house_id bigint(20) unsigned null, " +
                "foreign key (house_id) references houses (id) on update cascade on delete cascade);";
        execute(sql);
    }

    public static void createHousesTable() {
        String sql = "create table if not exists houses(id serial primary key, " +
                "address varchar(40) not null);";
        execute(sql);
    }

    private static void execute(String sql) {
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
