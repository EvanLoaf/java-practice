package com.gmail.evanloafakahaitao.hwk.hwk16;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.Arrays;

public class ArrayMaxNumberService implements Runnable {

    @Override
    public void run() {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = InputService.getRandomNumberInRange(0, 50);
        }
        int maxNumber = Arrays.stream(ints).max().getAsInt();
        System.out.println(Thread.currentThread().getName() + " - max El : " + maxNumber);
    }
}
