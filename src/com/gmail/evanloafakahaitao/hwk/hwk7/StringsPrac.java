package com.gmail.evanloafakahaitao.hwk.hwk7;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.Scanner;

public class StringsPrac {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String task1 = InputService.getString();
        symbolsSimilarToLastInString(task1);

        stringsWithSpecificWordsCounter(InputService.getNumber());

        String task3 = "На вопрос \"Откуда?\" - От верблюда! На вопрос \"Зачем?\" - Затем! " +
                        "На вопрос \"Что?\"- Цирк Шапито! На вопрос \"Как?\"- На тебя напал столбняк!";
        System.out.println(deleteSpacesBetweenSecondAndThirdQuestionMark(task3));

    }

    public static void symbolsSimilarToLastInString(String text) {
        Character last = text.charAt(text.length() - 1);
        int currentIndex = 0;
        while (currentIndex + 1 < text.length()) {
            if (currentIndex < 0) break;
            if (text.charAt(currentIndex) == last) {
                System.out.println(String.format("Char similar to %c with index %d", last, currentIndex));

            }
            currentIndex++;
        }
    }

    public static void stringsWithSpecificWordsCounter(int numberOfStrings) {
        String[] strings = new String[numberOfStrings];
        int notContainingSpecificWordsCounter = 0;
        for (int i = 0; i < strings.length; i++) {
            System.out.println("String pls, mby with cat/dog xd");
            strings[i] = scanner.nextLine();
        }
        for (String string : strings) {
            if (string.contains("cat") || string.contains("dog")) {
                System.out.println(String.format("String containing cat/dog: %s || Length: %d", string, string.length()));
            } else notContainingSpecificWordsCounter++;
        }
        System.out.println("Do not contain cat/dog: " + notContainingSpecificWordsCounter);
    }

    public static String deleteSpacesBetweenSecondAndThirdQuestionMark(String text) {
        int questionMarkCount = 0;
        int secondQuestionMarkIndex = -1;
        int thirdQuestionMarkIndex = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '?') {
                questionMarkCount++;
                if (questionMarkCount == 2) {
                    secondQuestionMarkIndex = i;
                } else if (questionMarkCount == 3) {
                    thirdQuestionMarkIndex = i;
                    break;
                }
            }
        }
        String subStr1 = text.substring(0, secondQuestionMarkIndex);
        String subStr2 = text.substring(secondQuestionMarkIndex, thirdQuestionMarkIndex);
        String subStr3 = text.substring(thirdQuestionMarkIndex);
        return subStr1.concat(subStr2.replaceAll(" ", "")).concat(subStr3);
    }
}
