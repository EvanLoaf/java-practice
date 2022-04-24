package com.gmail.evanloafakahaitao.hwk.hwk26;

import com.gmail.evanloafakahaitao.hwk.hwk26.model.Flat;

import java.util.List;

public interface FlatDao {

    void save(Flat flat);

    Flat getById(Long id);

    int populateFlatsWithSizeBelowAndNumberOfRooms(int size, int numberOfRooms);

    List<Flat> getPopulated();
}
