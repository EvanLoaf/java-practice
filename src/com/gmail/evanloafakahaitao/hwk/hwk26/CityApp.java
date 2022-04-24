package com.gmail.evanloafakahaitao.hwk.hwk26;


import com.gmail.evanloafakahaitao.hwk.hwk26.connection.ConnectionService;
import com.gmail.evanloafakahaitao.hwk.hwk26.impl.FlatDaoImpl;
import com.gmail.evanloafakahaitao.hwk.hwk26.impl.HouseDaoImpl;
import com.gmail.evanloafakahaitao.hwk.hwk26.model.Flat;
import com.gmail.evanloafakahaitao.hwk.hwk26.model.House;
import com.gmail.evanloafakahaitao.hwk.hwk26.service.DatabaseService;
import com.gmail.evanloafakahaitao.hwk.hwk26.service.GeneratorService;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CityApp {

    private CityApp() {}

    private static class Holder {
        private static final CityApp cityApp = new CityApp();
    }

    public static CityApp getInstance() {
        return Holder.cityApp;
    }

    public void runApp() {
        DatabaseService.createDatabase();
        DatabaseService.createHousesTable();
        DatabaseService.createFlatsTable();

        GeneratorService.getInstance().generateFlatsAndHouses(3, 20);

        HouseDao houseDao = new HouseDaoImpl();
        FlatDao flatDao = new FlatDaoImpl();
        int changedRows = flatDao.populateFlatsWithSizeBelowAndNumberOfRooms(50, 1);
        System.out.println("Populated = " + changedRows);
        List<Flat> flatList = flatDao.getPopulated();
        System.out.println("All populated flats ::");
        flatList.forEach(System.out::println);
        System.out.println("Flat with random id = 13");
        System.out.println(flatDao.getById(13L));
        List<House> houseList = houseDao.getHouses();
        System.out.println("Here's houses ::");
        houseList.forEach(System.out::println);

        Connection connection = ConnectionService.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            String sql = "create procedure insert_house(in house_address varchar(20)) begin insert into houses (address) values(house_address); end;";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (CallableStatement callableStatement = connection.prepareCall("{call insert_house(?)}")) {
            callableStatement.setString(1, "BIGADDRESS");
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionService.getInstance().closeConnection();

    }

}
