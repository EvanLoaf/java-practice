package com.gmail.evanloafakahaitao.hwk.hwk13;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileService {

    public String textReader(String path) {
        StringBuilder string = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                string.append(line);
                string.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.toString().replaceAll("(\\b[a-zA-Z0-9]{3,5}\\b)", "").replaceAll("\\s{2,}", " ");
    } // string.toString().replaceAll("\\s*\\b[a-zA-Z0-9]{3,5}\\b\\s*", "");

    public void writeResult(String path, String text) {
        File file = new File(path);
        boolean created = false;
        if (!file.exists()) {
            try {
                created = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("file created : %s%n", created);
        try {
            Files.write(Paths.get(path), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
