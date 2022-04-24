package com.gmail.evanloafakahaitao.prac.class13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class StringReaderService {

    public static void fileStringAnalyzer(Path file) {
        int counter = 0;
        try (FileReader input = new FileReader(file.toString())) {
            int character;
            while ((character = input.read()) != -1) {
                if ((char) character == 'a') counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("File has %d letters \'a\'", counter);
    }

    public static void bufferedStringAnalyzer(Path file) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int counter = 0;
        for (int i = 0; i < builder.length(); i++) {
            if (Character.toLowerCase(builder.charAt(i)) == Character.toLowerCase('a')) {
                counter++;
            }
        }
        System.out.printf("File has %d letters \'a\'%n", counter);
    }
}
