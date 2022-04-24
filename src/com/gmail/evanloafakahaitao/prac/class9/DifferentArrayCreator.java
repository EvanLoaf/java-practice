package com.gmail.evanloafakahaitao.prac.class9;

import com.gmail.evanloafakahaitao.util.InputService;

public class DifferentArrayCreator implements ArrayWorks<String> {

    private int numberOfElements;

    public DifferentArrayCreator(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @Override
    public int[] createArray() {
        int[] myArray = new int[numberOfElements];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = InputService.getRandomNumberInRange(0, 100);
        }
        return myArray;
    }

    @Override
    public int minArrayElement(String comment) {
        int[] myArray = createArray();
        int minElement = Integer.MAX_VALUE;
        for (int i : myArray) {
            if (i < minElement) minElement = i;
        }
        System.out.println("Work done! " + comment);
        return minElement;
    }
}
