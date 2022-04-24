package com.gmail.evanloafakahaitao.hwk.hwk6;

import com.gmail.evanloafakahaitao.util.InputService;

public class ConsoleStuff {

    public static void main(String[] args) {
        int input1 = InputService.getNumber();
        countDigitsInNumberAndTheirSum(input1);
        int input2 = InputService.getNumber();
        int input3 = InputService.getNumber();
        int input4 = InputService.getNumber();
        arrayGenerationAndEvenCounter(input2, input3, input4);
        int input5 = InputService.getNumber();
        System.out.println(String.format("Number generated [-%s;%s] : %s", input5, input5, numberGenerator(input5)));
    }

    public static void countDigitsInNumberAndTheirSum(int number) {
        int digits = 0;
        int sumOfDigits = 0;
        String numberStr = String.valueOf(number);
        digits = numberStr.length();
        sumOfDigits = numberStr.chars().map(Character::getNumericValue).sum();
        System.out.println(String.format("Digits: %s, their sum: %s", digits, sumOfDigits));
    }

    public static void arrayGenerationAndEvenCounter(int arrLength, int min, int max) {
        int[] myArray = new int[arrLength];
        int evenCounter = 0;
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = InputService.getRandomNumberInRange(min, max);
        }
        for (int i : myArray) {
            if (i % 2 == 0) evenCounter++;
        }
        System.out.println("Even numbers in array: " + evenCounter);
    }

    public static int numberGenerator(int maxAbsValue) {
        return (int) (Math.floor(Math.random() * (maxAbsValue * 2 + 1) - maxAbsValue));
    }
}
