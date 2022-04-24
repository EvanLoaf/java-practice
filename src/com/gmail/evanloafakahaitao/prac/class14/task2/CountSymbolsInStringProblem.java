package com.gmail.evanloafakahaitao.prac.class14.task2;

import com.gmail.evanloafakahaitao.util.InputService;

public class CountSymbolsInStringProblem {

    public void countingSymbolsInString() {
        System.out.println("Yo, need a str to count symbols in");
        String input = InputService.getString();
        System.out.println("You, what symbol to count?");
        char charOfInterest = InputService.getString().charAt(0);
        int numberOfCharFound = 0;
        char[] stringChars = input.toCharArray();
        for (char stringChar : stringChars) {
            if (stringChar == charOfInterest) numberOfCharFound++;
        }
        System.out.printf("Given string: %s%nGiven symbol: %s%nFound: %d", input, charOfInterest, numberOfCharFound);
    }
}
