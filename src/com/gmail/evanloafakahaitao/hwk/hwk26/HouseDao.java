package com.gmail.evanloafakahaitao.hwk.hwk26;

import com.gmail.evanloafakahaitao.hwk.hwk26.model.House;

import java.util.List;

public interface HouseDao {

    void save(House house);

    List<House> getHouses();
}
