package com.gmail.evanloafakahaitao.prac.class6;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.Random;

public class ArrayRandom {

    public static void main(String[] args) {
        arrayMaxNumber(69);
        arrayAnalyzer(69);
    }

    public static void arrayMaxNumber(int arrayLength) {
        int maxNumber = Integer.MIN_VALUE;
        int[] numbers = new int[arrayLength];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = InputService.getRandomNumberInRange(0, 50);
        }
        for (int number : numbers) {
            maxNumber = number > maxNumber ? number : maxNumber;
        }
        System.out.println("Max number: " + maxNumber);
    }

    public static void arrayAnalyzer(int arrayLength) {
        int[] numbers = new int[arrayLength];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = InputService.getRandomNumberInRange(0, 50);
        }
        StringBuilder string = new StringBuilder();
        for (int number : numbers) {
            if (number * 10 <= 200) string.append(number).append(" ");
        }
        System.out.println("Number that are not exceeding 200 when multiplied by 10: " + string);
    }
}
