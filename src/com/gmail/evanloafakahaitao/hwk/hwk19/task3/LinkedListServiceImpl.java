package com.gmail.evanloafakahaitao.hwk.hwk19.task3;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.LinkedList;
import java.util.List;

public class LinkedListServiceImpl implements ListService {

    @Override
    public List<Integer> generateList() {
        List<Integer> integerList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            integerList.add(InputService.getRandomNumberInRange(0, 20));
        }
        return integerList;
    }
}
