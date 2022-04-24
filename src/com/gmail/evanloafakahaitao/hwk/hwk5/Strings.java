package com.gmail.evanloafakahaitao.hwk.hwk5;

import java.util.Arrays;
import java.util.Collections;

public class Strings {

    public static void main(String[] args) {
        backwardsString("one two three FOUR five");
        backwardsStringEvo("one two three FOUR five SIX seven");

        deleteShortWords("i really never liked all the short words", 5);
        deleteShortWords("short words are the worst foshooo", 7);

        replaceLastThreeCharsInWordsOfGivenLength("This is a sample text with many words", 4);
        replaceLastThreeCharsInWordsOfGivenLength("This is a sample text with many words brotha", 6);

        replaceLastThreeCharsInWordsOfGivenLength(new String[]{"word1", "word2", "word33", "word44", "word5"}, 5);
        replaceLastThreeCharsInWordsOfGivenLength(new String[]{"word1", "word2", "word33", "word44", "word5"}, 6);

        replaceLastThreeCharsInWordsOfGivenLengthImproved(new String[]{"word1", "word2", "word33", "word44", "word5"}, 5);
        replaceLastThreeCharsInWordsOfGivenLengthImproved(new String[]{"word1", "word2", "word33", "word44", "word5"}, 6);

        addSpacesAfterPunctuations("Text, with a,bunch of,commas and no,spaces");
        addSpacesAfterPunctuations("Text,commas are best, friends,yo");

    }

    public static void backwardsString(String string) {
        String[] words = string.split(" ");
        StringBuilder newString = new StringBuilder();
        for (int i = words.length; i > 0; i--) {
            newString.append(words[i - 1]).append(" ");
        }
        System.out.println(String.format("Backwards line: %s", newString));
    }

    public static void backwardsStringEvo(String string) {
        String[] words = string.split(" ");
        Collections.reverse(Arrays.asList(words));
        String newString = String.join(" ", words);
        System.out.println(String.format("Backwards line by omega methods: %s", newString));
    }

    public static void deleteShortWords(String text, int minWordLength) {
        String editedText = text.replaceAll("\\b[a-zA-Z0-9]{1,4}\\b", "")
                                .replaceAll("\\s\\s", " ");
        System.out.println("Edited text " + editedText);
    }

    public static void replaceLastThreeCharsInWordsOfGivenLength(String text, int wordLength) {
        StringBuilder regex =  new StringBuilder("(?<=\\b[a-zA-Z]{").append(wordLength - 3).append("})")
                                    .append("(?=[a-zA-Z]{3})[a-zA-Z]{3}\\b");
        String editedText = text.replaceAll(regex.toString(), "\\$\\$\\$");
        System.out.println("Text with replaced last chars using REGEX: " + editedText);
    }

    public static void replaceLastThreeCharsInWordsOfGivenLength(String[] words, int wordLength) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == wordLength) {
                char[] chars = words[i].toCharArray();
                for (int j = chars.length - 3; j < chars.length; j++) {
                    chars[j] = '$';
                }
                words[i] = String.valueOf(chars);
            }
        }
        System.out.println("Text with replaced last chars using Array > words > chars > replace last > assemble");
        System.out.println(Arrays.asList(words));
    }

    public static void replaceLastThreeCharsInWordsOfGivenLengthImproved(String[] words, int wordLength) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == wordLength) {
                words[i] = words[i].substring(0, wordLength - 3).concat("$$$");
            }
        }
        System.out.println("Text with replaced last chars using substring and concat");
        System.out.println(Arrays.asList(words));
    }

    public static void addSpacesAfterPunctuations(String text) {
        text = text.replaceAll("(?<=\\,)([^\\s])", " $1");
        System.out.println("Text now with spaces after punct: " + text);
    }
}
