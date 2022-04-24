package com.gmail.evanloafakahaitao.prac.class16;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class ThreadCalcArrayService implements Runnable {
    @Override
    public void run() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(InputService.getRandomNumberInRange(0, 10));
        }
        Double avg = integerList.stream().reduce(Integer::sum).orElse(0).doubleValue();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread name : %s, avg of numbers : %f%n", Thread.currentThread(), avg / 10);
    }
}
