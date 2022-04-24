package com.gmail.evanloafakahaitao.hwk.hwk17.task3;

import java.util.List;
import java.util.concurrent.Callable;

public class SumThread implements Callable<Integer> {

    private List<String> numbersList;

    public SumThread(List<String> numbersList) {
        this.numbersList = numbersList;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (String string : numbersList) {
            String[] numbers = string.split(",");
            for (String number : numbers) {
                sum += Integer.valueOf(number);
            }
        }
        System.out.println("Sum service : " + sum);
        return sum;
    }
}
