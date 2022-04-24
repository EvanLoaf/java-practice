package com.gmail.evanloafakahaitao.prac.class17;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class NumberSumService implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.printf("%s zug zug doing work%n", Thread.currentThread().getName());
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(InputService.getRandomNumberInRange(0, 100));
        }
        int sum = integerList.stream().reduce(0, Integer::sum);
        Thread.sleep((long) (((Math.random() * 9) + 1) * 1000));
        System.out.printf("%s is done%n", Thread.currentThread().getName());
        return String.valueOf(sum);
    }
}
