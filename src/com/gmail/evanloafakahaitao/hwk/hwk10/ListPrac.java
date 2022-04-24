package com.gmail.evanloafakahaitao.hwk.hwk10;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class ListPrac {

    public static void main(String[] args) {
        List<Integer> myList = listBuilder();
        twoMaxElements(myList);

        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(InputService.getString());
        stringArrayList.add(InputService.getString());
        stringArrayList.add(InputService.getString());
        stringArrayList.add(InputService.getString());
        stringArrayList.add(InputService.getString());
        stringArrayList.forEach(System.out::println);
        stringArrayList.replaceAll(e -> e.replaceAll("\\+", "+++"));
        stringArrayList.forEach(System.out::println);

        ArrayList<Person> personArrayList = new ArrayList<>();
        System.out.println("Hoe many ppl to create?");
        int numOfPeople = InputService.getNumber();
        for (int i = 0; i < numOfPeople; i++) {
            personArrayList.add(new Person(
                    "Name" + i,
                    "Surname" + i,
                    InputService.getRandomNumberInRange(15, 30)
            ));
        }
        personArrayList.forEach(person -> System.out.println(person.getAge() < 18 ?
                String.format("Infant %s %s, age: %d", person.getName(), person.getSurname(), person.getAge())
         :
                String.format("Adult %s %s, age: %d", person.getName(), person.getSurname(), person.getAge())
        ));
    }

    public static List<Integer> listBuilder() {
        System.out.println("How many numbers to put in?");
        int listLength = InputService.getNumber();
        List<Integer> integerList = new ArrayList<>((int) Math.ceil(listLength / 0.75));
        for (int i = 0; i < listLength; i++) {
            integerList.add(InputService.getRandomNumberInRange(2, 98));
        }
        return integerList;
    }

    public static void twoMaxElements(List<Integer> integerList) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (Integer integer : integerList) {
            if (integer > firstMax) {
                secondMax = firstMax;
                firstMax = integer;
            } else if (integer > secondMax) {
                secondMax = integer;
            }
        }
        System.out.println(String.format("Two max elements are %d and %d", firstMax, secondMax));
    }

}


