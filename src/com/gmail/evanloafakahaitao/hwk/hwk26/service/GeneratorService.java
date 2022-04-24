package com.gmail.evanloafakahaitao.hwk.hwk26.service;

import com.gmail.evanloafakahaitao.hwk.hwk26.FlatDao;
import com.gmail.evanloafakahaitao.hwk.hwk26.HouseDao;
import com.gmail.evanloafakahaitao.hwk.hwk26.impl.FlatDaoImpl;
import com.gmail.evanloafakahaitao.hwk.hwk26.impl.HouseDaoImpl;
import com.gmail.evanloafakahaitao.hwk.hwk26.model.Flat;
import com.gmail.evanloafakahaitao.hwk.hwk26.model.House;
import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class GeneratorService {

    private static FlatDao flatDao;
    private static HouseDao houseDao;

    static {
        flatDao = new FlatDaoImpl();
        houseDao = new HouseDaoImpl();
    }

    private static GeneratorService generatorService;

    public static GeneratorService getInstance() {
        if (generatorService == null) {
            generatorService = new GeneratorService();
        }
        return generatorService;
    }

    public void generateFlatsAndHouses(int numberOfHouses, int flatsPerHouse) {
        for (int i = 0; i < numberOfHouses; i++) {
            House house = House.newBuilder()
                    .withAddress("address" + i)
                    .build();
            houseDao.save(house);
            for (int j = 0; j < flatsPerHouse; j++) {
                Flat flat = Flat.newBuilder()
                        .withCountOfRooms(InputService.getRandomNumberInRange(1, 3))
                        .withFloor(InputService.getRandomNumberInRange(1, 5))
                        .withSize(String.valueOf(InputService.getRandomNumberInRange(40, 80)))
                        .withHouse(house)
                        .build();
                flatDao.save(flat);
            }
        }
    }
}
