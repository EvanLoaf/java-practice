package com.gmail.evanloafakahaitao.prac.class13;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Path stinrgFile = Paths.get("../string.txt");
        StringReaderService.fileStringAnalyzer(stinrgFile);
        StringReaderService.bufferedStringAnalyzer(stinrgFile);

        InfoWriterService infoWriterService = new InfoWriterService();
        List<Person> personList = infoWriterService.createPersonList();
        Path personFile = Paths.get("person.txt");
        infoWriterService.writePeopleToFile(personList, personFile);
    }
}
