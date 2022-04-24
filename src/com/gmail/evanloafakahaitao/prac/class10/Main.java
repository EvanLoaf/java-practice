package com.gmail.evanloafakahaitao.prac.class10;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            students.add(new Student(
                    "Vasya" + i, InputService.getRandomNumberInRange(21, 30), InputService.getRandomNumberInRange(1, 3)
            ));
        }
        printStudents(students, 3);

    }

    public static void printStudents(List<Student> students, int course) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCourse() == course) System.out.println(student.getName());
        }
    }
}
