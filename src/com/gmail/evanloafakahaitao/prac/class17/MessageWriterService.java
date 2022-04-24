package com.gmail.evanloafakahaitao.prac.class17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MessageWriterService implements Callable<String> {

    @Override
    public String call() throws Exception {
        String string = writeToFile();
        Thread.sleep(10);
        return string;
    }

    private synchronized String writeToFile() {
        System.out.printf("%s zug zug doing work%n", Thread.currentThread().getName());
        String string = "Hello world " + LocalDateTime.now();
        String path = "..\\my\\datetime.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(string);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%s is done%n", Thread.currentThread().getName());
        return string;
    }
}
