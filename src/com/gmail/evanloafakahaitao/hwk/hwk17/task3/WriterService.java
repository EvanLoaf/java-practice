package com.gmail.evanloafakahaitao.hwk.hwk17.task3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterService {

    private File numbersFile;

    public WriterService(File numbersFile) {
        this.numbersFile = numbersFile;
    }

    public void writeFile(List<String> stringList) {
        synchronized (numbersFile) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(numbersFile))) {
                for (String string : stringList) {
                    bw.write(string);
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
