package com.gmail.evanloafakahaitao.prac.class18.task1;


import java.util.List;
import java.util.concurrent.Callable;

public class MaxNumberThread implements Callable<Integer> {

    private List<Integer> integerList;

    public MaxNumberThread(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public Integer call() throws Exception {
        int maxNumber = integerList.get(0);
        for (Integer integer : integerList) {
            maxNumber = Math.max(maxNumber, integer);
        }
        System.out.println("Max = " + maxNumber);
        return maxNumber;
    }
}
