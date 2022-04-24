package com.gmail.evanloafakahaitao.hwk.hwk13;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        NumberFileReader numberFileReader = new NumberFileReader();
        Path file = Paths.get("..\\readable_numbers.txt");
        List<Integer> integerList = numberFileReader.readNumbersFromFile(file);
        integerList.forEach(System.out::println);
        System.out.printf("Max element: %d%n", numberFileReader.findMax(integerList));

        String path = "..\\SUPANUMBERS.txt";
        NumberFileWriter numberFileWriter = new NumberFileWriter();
        System.out.println("Created file?");
        System.out.println(numberFileWriter.createFile(path));
        numberFileWriter.writeNumbers(path);

        TextFileService textFileService = new TextFileService();
        String textPath = "..\\text_file.txt";
        String textPathToWrite = "..\\my\\test\\SUPAFILE.txt";
        String text = textFileService.textReader(textPath);
        textFileService.writeResult(textPathToWrite, text);

        PersonFileService personFileService = new PersonFileService();
        String personFilePath = "..\\person_parse.txt";
        personFileService.writePersons(personFilePath);
        List<Person> retrievedList = personFileService.parsePersonsFromFile(personFilePath);
        Person maxBirthYear = retrievedList.stream().max(Comparator.comparing(Person::getBirthYear)).get();
        System.out.printf("Max birth year person : %n%s%n", maxBirthYear.toString());

    }
}
