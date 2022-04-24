package com.gmail.evanloafakahaitao.prac.class13.supatask;

import com.gmail.evanloafakahaitao.util.InputService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        MyDirectoryService myDirectoryService = new MyDirectoryService();
        Path directory = Paths.get("..\\my\\test\\path");
        boolean success = myDirectoryService.createDirectories(directory);
        System.out.println("Created dir? " + success);
        System.out.println("How many files to create?");
        int numOfFiles = InputService.getNumber();
        System.out.println("How many number to add to each file?");
        int numOfNumbers = InputService.getNumber();
        myDirectoryService.createAndFillFiles(directory, numOfFiles, numOfNumbers);
        myDirectoryService.readFilesAndAssemble(directory);
        myDirectoryService.showCatalogue(directory);
    }
}
