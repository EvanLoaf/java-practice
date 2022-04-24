package com.gmail.evanloafakahaitao.prac.class14.task6;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StringIOService {

    public void writeStudentsToFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < 10; i++) {
                bw.write(new Student(
                        i + 1,
                        "Name" + i,
                        "Surname" + i,
                        InputService.getRandomNumberInRange(1, 10),
                        InputService.getRandomNumberInRange(1, 10),
                        InputService.getRandomNumberInRange(1, 10)
                ).toString());
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeStudentsToFile(String path, List<Student> studentList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Student student : studentList) {
                bw.write(student.toString());
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> readStudents(String path) {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] studentFields = line.split(" ");
                studentList.add(new Student(
                        Integer.valueOf(studentFields[0]),
                        studentFields[1],
                        studentFields[2],
                        Integer.valueOf(studentFields[3]),
                        Integer.valueOf(studentFields[4]),
                        Integer.valueOf(studentFields[5])
                ));
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Heres the students from file: \n");
        System.out.println(studentList);
        return studentList;
    }

    public void changeStudent(String path) {
        List<Student> studentList = readStudents(path);
        System.out.println("Whose surname will be \'lalka\'? #1-10");
        int studentToChange = InputService.getNumber();
        Student chosenStudent = studentList.stream().filter(student -> student.getNumber() == studentToChange).findFirst().get();
        chosenStudent.setLastName("lalka228");
        writeStudentsToFile(path, studentList);

    }
}
