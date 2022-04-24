package com.gmail.evanloafakahaitao.prac.class9;

import com.gmail.evanloafakahaitao.util.InputService;

public class ArrayCreator implements ArrayWorks<int[]> {

    private int numberOfElements;

    public ArrayCreator(int numberOfElements) {
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
    public int minArrayElement(int[] myArray) {
        int minElement = Integer.MAX_VALUE;
        for (int i : myArray) {
            if (i < minElement) minElement = i;
        }
        return minElement;
    }
}
