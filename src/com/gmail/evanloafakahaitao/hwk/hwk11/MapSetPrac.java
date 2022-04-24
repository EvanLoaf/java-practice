package com.gmail.evanloafakahaitao.hwk.hwk11;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.*;

public class MapSetPrac {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            integerList.add(InputService.getRandomNumberInRange(0, 20));
        }
        System.out.println("List : " + integerList);
        Map<Integer, Integer> integerMap = new HashMap<>();
        integerList.forEach(integer -> {
            integerMap.computeIfPresent(integer, (k, v) -> ++v);
            integerMap.putIfAbsent(integer, 1);
        });
        System.out.println("Map int counter results : " + integerMap);

        Map<String, String> stringMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            stringMap.put("Key" + i, "Value" + i);
        }
        stringMap.forEach((k, v) -> System.out.println(k));
        stringMap.keySet().forEach(System.out::println);

        Set<Person> personSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            personSet.add(new Person(
                    "Name" + i,
                    "Surname" + i,
                    InputService.getRandomNumberInRange(1994, 1996)
            ));
        }
        List<Person> personList = new ArrayList<>(personSet);
        personList.sort((a, b) -> a.getBirthYear() != b.getBirthYear() ?
                a.getBirthYear() - b.getBirthYear() : !a.getLastName().equals(b.getLastName()) ?
                a.getLastName().compareToIgnoreCase(b.getLastName()) : a.getFirstName().compareToIgnoreCase(b.getFirstName()));
        System.out.println(personList);


    }
}
