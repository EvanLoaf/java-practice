package com.gmail.evanloafakahaitao.hwk.hwk22.task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WriteFileThread implements Runnable {

    private String path;
    private String phrase;

    public WriteFileThread(String path, String phrase) {
        this.path = path;
        this.phrase = phrase;
    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            File file = new File(path);
            if (!file.exists()) file.createNewFile();
            List<String> stringList = generateList(phrase);
            for (String string : stringList) {
                System.out.printf("%s output = %s%n", Thread.currentThread().getName(), string);
                bw.write(string);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> generateList(String phrase) {
        List<String> stringList = Arrays.asList(phrase.split(" "));
        Collections.shuffle(stringList);
        List<String> outputStrings = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            outputStrings.add(stringList.get(i));
        }
        return outputStrings;
    }
}
