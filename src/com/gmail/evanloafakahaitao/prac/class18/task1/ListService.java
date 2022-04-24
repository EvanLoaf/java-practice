package com.gmail.evanloafakahaitao.prac.class18.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ListService implements Callable<List<Integer>> {

    private int amountOfNumbers;

    public ListService(int amountOfNumbers) {
        this.amountOfNumbers = amountOfNumbers;
    }

    public List<Integer> createIntList(int amountOfNumbers) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < amountOfNumbers; i++) {
            integerList.add(InputService.getRandomNumberInRange(0, 100));
        }
        return integerList;
    }

    @Override
    public List<Integer> call() {
        return createIntList(amountOfNumbers);
    }
}
