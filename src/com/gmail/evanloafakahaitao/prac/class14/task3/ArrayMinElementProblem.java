package com.gmail.evanloafakahaitao.prac.class14.task3;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ArrayMinElementProblem {

    public void findAvgOfNegativeElementsAndReplaceMinElement() {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = InputService.getRandomNumberInRange(-100, 100);
        }
        int sumOfNegativeNumbers = 0;
        int countOfNegativeNumbers = 0;
        int smallestNumber = 0;
        int smallestNumberIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                sumOfNegativeNumbers += numbers[i];
                countOfNegativeNumbers++;
                if (numbers[i] < smallestNumber) {
                    smallestNumber = numbers[i];
                    smallestNumberIndex = i;
                }
            }
        }
        int minNumber = Arrays.stream(numbers).min().getAsInt();
        System.out.printf("Min number : %d", minNumber);

        int negativeNumbersAvg = (int) Math.floor(sumOfNegativeNumbers / countOfNegativeNumbers);
        System.out.println("Before");
        System.out.println(Arrays.toString(numbers));
        numbers[smallestNumberIndex] = negativeNumbersAvg;
        System.out.println("After");
        System.out.println(Arrays.toString(numbers));

    }
}
