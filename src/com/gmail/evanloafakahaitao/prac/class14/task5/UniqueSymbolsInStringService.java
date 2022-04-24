package com.gmail.evanloafakahaitao.prac.class14.task5;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.HashMap;
import java.util.Map;

public class UniqueSymbolsInStringService {

    public void countSymbolsInString() {
        System.out.println("String to count symbols in");
        String input = InputService.getString();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            characterIntegerMap.computeIfPresent(character, (k, v) -> v + 1);
            characterIntegerMap.putIfAbsent(character, 1);
        }
        System.out.println("Analysis of symbols from input: ");
        System.out.println(characterIntegerMap);
        System.out.println("or like this");
        for (Map.Entry<Character, Integer> characterIntegerEntry : characterIntegerMap.entrySet()) {
            System.out.printf("Symbol: %s | Repeats %d times.%n", characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
        }
    }
}
