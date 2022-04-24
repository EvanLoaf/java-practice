package com.gmail.evanloafakahaitao.prac.class7;

import java.util.Arrays;
import java.util.Scanner;

public class StringsPrac {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tortBuilder();
        System.out.println("Gimme my weird text with A's and numbers and 9's");
        String text = scanner.nextLine();
        letterReplacer(text, "a", "b");
        numberDeleter(text);
        digitNineCounter(text);
        String[] strArray  = {"String1", "String2", "String3", "String4", "String5", "String6", "String7", "String8",
                            "String9", "String10", "String11", "String12", "String13", "String14", "String15"};
        longestStringInArray(strArray);
        allLongestStringsInArray(strArray);
    }

    public static void tortBuilder() {
        String informatika = "technologyr";
        StringBuilder tort = new StringBuilder();
        System.out.println(tort.append(informatika.charAt(informatika.indexOf("t"))).
                                append(informatika.charAt(informatika.indexOf("o"))).
                                append(informatika.charAt(informatika.indexOf("r"))).
                                append(informatika.charAt(informatika.indexOf("t"))));
        System.out.println(tort);
    }

    public static void letterReplacer(String text, String letterToReplace, String replacingLetter) {
        String editedStr = text.replaceAll(letterToReplace, replacingLetter);
        System.out.println(editedStr);
    }

    public static void numberDeleter(String text) {
        String editedStr = text.replaceAll("\\d", "");
        System.out.println(editedStr);
    }

    public static void digitNineCounter(String text) {
        int textLength = text.length();
        int currentIndex = 0;
        int digitNineCounter = 0;
        int digitNineIndex = 0;
        while (currentIndex < textLength) {
            digitNineIndex = text.indexOf('9', currentIndex);
            if (digitNineIndex < 0) break;
            currentIndex = digitNineIndex + 1;
            digitNineCounter++;
        }
        System.out.println("digits nine: " + digitNineCounter);
    }

    public static void longestStringInArray(String[] strings) {
        if (strings == null || strings.length == 0) return;
        int longestStringLength = strings[0].length();
        int longestStringIndex = 0;
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > longestStringLength) {
                longestStringIndex = i;
                longestStringLength = strings[i].length();
            }
        }
        System.out.println(String.format("Longest string index: %s || Longest string: %s",
                                        longestStringIndex, strings[longestStringIndex]));
    }

    public static void allLongestStringsInArray(String[] strings) {
        if (strings == null || strings.length == 0) return;
        int longestStringLength = strings[0].length();
        int numberOfLongestStrings = 1;
        String[] longestStrings = new String[strings.length];
        longestStrings[0] = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > longestStringLength) {
                Arrays.fill(longestStrings, null);
                longestStringLength = strings[i].length();
                numberOfLongestStrings = 1;
                longestStrings[0] = strings[i];
            } else if (strings[i].length() == longestStringLength) {
                numberOfLongestStrings++;
                longestStrings[numberOfLongestStrings - 1] = strings[i];
            }
        }
        System.out.println(String.format("Number of longest strings: %s || Longest strings: %s",
                numberOfLongestStrings, String.join(", ", longestStrings)));
    }
}
