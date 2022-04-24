package com.gmail.evanloafakahaitao.prac.class6;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.Arrays;

public class ScannerTasks {

    public static void main(String[] args) {
        double avg = averageNumber(5);
        System.out.println("avg " + avg);
        numberOperator(7);

    }

    public static double averageNumber(int inputLength) {
        double sum = 0;
        for (int i = 0; i < inputLength; i++) {
            sum += InputService.getNumber();
        }
        return sum / inputLength;
    }

    public static void numberOperator(int inputLength) {
        Integer[] numbers = new Integer[inputLength];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = InputService.getNumber();
        }
        System.out.println("Numbers array: " + Arrays.asList(numbers));
        StringBuilder divisibleByFiveAndSeven = new StringBuilder();
        for (int i : numbers) {
            if (i % 5 == 0 && i % 7 == 0) divisibleByFiveAndSeven.append(i).append(" ");
        }
        System.out.println(String.format("divisible by 5 and 7: %s", divisibleByFiveAndSeven));
    }
}
