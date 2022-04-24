package com.gmail.evanloafakahaitao.prac.class26.impl;

import com.gmail.evanloafakahaitao.prac.class26.UserDAO;
import com.gmail.evanloafakahaitao.prac.class26.UserDTO;
import com.gmail.evanloafakahaitao.prac.class26.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO {

    @Override
    public int addUsers(List<UserDTO> userDTOList) {
        int updatedRows = 0;
        try (Connection connection = ConnectionService.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            for (UserDTO userDTO : userDTOList) {
                String sql = "insert into users (first_name, city, salary) values (\'" + userDTO.getFirstName()
                        + "\', \'" + userDTO.getCity() +"\', \'" + userDTO.getSalary() + "\');";
                int changed = statement.executeUpdate(sql);
                updatedRows += changed;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        String sql = "select * from users;";
        try (Connection connection = ConnectionService.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                UserDTO userDTO = new UserDTO();
                userDTO.setSalary(resultSet.getInt("salary"));
                userDTO.setFirstName(resultSet.getString("first_name"));
                userDTO.setCity(resultSet.getString("city"));
                userDTOList.add(userDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDTOList;
    }

    @Override
    public void createTable() {
        try (Connection connection = ConnectionService.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            String sql = "create table if not exists users(id serial primary key, first_name varchar(20) not null, " +
                    "city varchar(20) not null default 'Minsk', salary int not null);";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTable() {
        try (Connection connection = ConnectionService.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            String sql = "drop table users;";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int updateCityInSalaryRange(String city, int minSalaryRange, int maxSalaryRange) {
        int updatedRows = 0;
        try (Connection connection = ConnectionService.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            String sql = "update users set city = \'" + city + "\' where salary between " + minSalaryRange + " and " + maxSalaryRange + ";";
            updatedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

    @Override
    public int updateCityAboveSalary(String city, int salary) {
        int updatedRows = 0;
        try (Connection connection = ConnectionService.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            String sql = "update users set city = \'" + city + "\' where salary > " + salary + ";";
            updatedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

    @Override
    public int deleteUsersBelowSalary(int salary) {
        int updatedRows = 0;
        try (Connection connection = ConnectionService.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            String sql = "delete from users where salary < " + salary + ";";
            updatedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }
}
