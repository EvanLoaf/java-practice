package com.gmail.evanloafakahaitao.hwk.hwk26.impl;

import com.gmail.evanloafakahaitao.hwk.hwk26.HouseDao;
import com.gmail.evanloafakahaitao.hwk.hwk26.connection.ConnectionService;
import com.gmail.evanloafakahaitao.hwk.hwk26.model.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {

    @Override
    public void save(House house) {
        String sql = "insert into houses (address) values (?);";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        PreparedStatement.RETURN_GENERATED_KEYS
                )) {
                    preparedStatement.setString(1, house.getAddress());
                    preparedStatement.executeUpdate();
                    try (ResultSet generatedKey = preparedStatement.getGeneratedKeys()) {
                        if (generatedKey.next()) {
                            house.setId(
                                    generatedKey.getLong(1)
                            );
                        } else throw new SQLException("House save error! No ID returned!");
                    }
                }
            } else throw new SQLException("No connection! Cant save house!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<House> getHouses() {
        List<House> houseList = new ArrayList<>();
        String sql = "select * from houses;";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sql)
                ) {
                    while (resultSet.next()) {
                        House house = House.newBuilder()
                                .withAddress(resultSet.getString("address"))
                                .withId(resultSet.getLong("id"))
                                .build();
                        houseList.add(house);
                    }
                }
            } else throw new SQLException("No connection! Cant get all house!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return houseList;
    }
}
