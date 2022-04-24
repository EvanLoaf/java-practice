package com.gmail.evanloafakahaitao.hwk.hwk19.task4;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskFourService {

    public List<Person> generatePersons() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = Person.newBuilder().withBirthYear(InputService.getRandomNumberInRange(1980, 2000))
                    .withName("Name" + i)
                    .withSurname("Surname" + i)
                    .build();
            personList.add(person);
        }
        return personList;
    }

    public void printOlderToYounger(List<Person> people) {
        people.stream().sorted(Comparator.comparingInt(Person::getBirthYear)).forEach(System.out::println);
    }
}
