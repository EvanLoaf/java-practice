package com.gmail.evanloafakahaitao.hwk.hwk26.impl;

import com.gmail.evanloafakahaitao.hwk.hwk26.FlatDao;
import com.gmail.evanloafakahaitao.hwk.hwk26.connection.ConnectionService;
import com.gmail.evanloafakahaitao.hwk.hwk26.model.Flat;
import com.gmail.evanloafakahaitao.hwk.hwk26.model.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlatDaoImpl implements FlatDao {

    @Override
    public void save(Flat flat) {
        String sql = "insert into flats (size, count_of_rooms, floor, house_id) values (?, ?, ?, ?);";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        PreparedStatement.RETURN_GENERATED_KEYS
                )) {
                    preparedStatement.setInt(1, Integer.valueOf(flat.getSize()));
                    preparedStatement.setInt(2, flat.getCountOfRooms());
                    preparedStatement.setInt(3, flat.getFloor());
                    preparedStatement.setLong(4, flat.getHouse().getId());
                    preparedStatement.executeUpdate();
                    try (ResultSet generatedKey = preparedStatement.getGeneratedKeys()) {
                        if (generatedKey.next()) {
                            flat.setId(
                                    generatedKey.getLong(1)
                            );
                        } else throw new SQLException("Flat save error! No ID returned!");
                    }
                }
            } else throw new SQLException("No connection! Cant save flat!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flat getById(Long id) {
        String sql = "select f.id, f.size, f.count_of_rooms, f.floor, f.is_populated, f.house_id, h.address " +
                "from flats f join houses h on f.house_id = h.id where f.id = ?;";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setLong(1, id);
                    preparedStatement.executeQuery();
                    try (ResultSet resultSet = preparedStatement.getResultSet()) {
                        if (resultSet.next()) {
                            return Flat.newBuilder()
                                    .withId(resultSet.getLong("id"))
                                    .withSize(String.valueOf(resultSet.getInt("size")))
                                    .withFloor(resultSet.getInt("floor"))
                                    .withCountOfRooms(resultSet.getInt("count_of_rooms"))
                                    .withIsPopulated(resultSet.getBoolean("is_populated"))
                                    .withHouse(
                                            House.newBuilder()
                                                    .withAddress(resultSet.getString("address"))
                                                    .withId(resultSet.getLong("house_id"))
                                                    .build()
                                    ).build();
                        } else throw new SQLException("Flat get by id error! No result!");
                    }
                }
            } else throw new SQLException("No connection! Cant get Flat by id!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int populateFlatsWithSizeBelowAndNumberOfRooms(int size, int numberOfRooms) {
        String sql = "update flats set is_populated = true where count_of_rooms = ? and size <= ?;";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, numberOfRooms);
                    preparedStatement.setInt(2, size);
                    return preparedStatement.executeUpdate();
                }
            } else throw new SQLException("No connection! Cant update flats!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Flat> getPopulated() {
        List<Flat> flatList = new ArrayList<>();
        String sql = "select c.count as amount, f.id, size, count_of_rooms, is_populated, floor, h.id as house_id, address " +
                "from flats f join houses h join " +
                "(select count(*) as count from flats f where f.is_populated = true) c " +
                "on f.house_id = h.id where f.is_populated = true;";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sql)
                ) {
                    while (resultSet.next()) {
                        Flat flat = Flat.newBuilder()
                                .withCountOfRooms(resultSet.getInt("count_of_rooms"))
                                .withFloor(resultSet.getInt("floor"))
                                .withSize(String.valueOf(resultSet.getInt("size")))
                                .withId(resultSet.getLong("id"))
                                .withIsPopulated(resultSet.getBoolean("is_populated"))
                                .withHouse(
                                        House.newBuilder()
                                        .withId(resultSet.getLong("house_id"))
                                        .withAddress(resultSet.getString("address"))
                                        .build()
                                ).build();
                        flatList.add(flat);
                        System.out.println("Fetching flats, total should be = " + resultSet.getInt("amount"));
                    }
                }
            } else throw new SQLException("No connection! Cant get populated flats!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flatList;
    }
}
