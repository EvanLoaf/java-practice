package com.gmail.evanloafakahaitao.prac.class13;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InfoWriterService {

    public List<Person> createPersonList() {
        System.out.println("How many ppl to create?");
        int number = InputService.getNumber();
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            personList.add(new Person(
                    "supaNAME" + i * 2,
                    "lastname" + i,
                    InputService.getRandomNumberInRange(10, 100)
            ));
        }
        return personList;
    }

    public void writePeopleToFile(List<? extends Person> personList, Path file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.toString(), true))) {
            personList.forEach(person -> {
                try {
                    bw.write(person.toString() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%d Person's written to the file %s%n", personList.size(), file.toString());
    }
}
