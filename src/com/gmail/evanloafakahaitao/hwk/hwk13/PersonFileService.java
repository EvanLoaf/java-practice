package com.gmail.evanloafakahaitao.hwk.hwk13;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileService {

    public void writePersons(String path) {
        System.out.println("How many people to create?");
        int number = InputService.getNumber();
        List<Person> personList = new ArrayList<>();
        int[] birthYears = new int[11];
        for (int i = 0; i < birthYears.length; i++) {
            birthYears[i] = 1960 + i;
        }
        for (int i = 0; i < number; i++) {
            Person person = new Person(
                    "Name" + i,
                    "Surname" + i,
                    birthYears[InputService.getRandomNumberInRange(0, 10)]
            );
            personList.add(person);
        }
        personList.forEach(System.out::println);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            personList.forEach(person -> {
                try {
                    bw.write(person.toString());
                    bw.write(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> parsePersonsFromFile(String path) {
        List<Person> personList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] parsedPerson = line.split(" ");
                personList.add(new Person(
                        parsedPerson[0],
                        parsedPerson[1],
                        Integer.valueOf(parsedPerson[2])
                ));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
