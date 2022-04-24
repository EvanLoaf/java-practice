package com.gmail.evanloafakahaitao.prac.class17;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class FireWriterService implements Callable<List<String>> {

    @Override
    public List<String> call() throws Exception {
        System.out.printf("%s zug zug doing work%n", Thread.currentThread().getName());
        List<String> files = new ArrayList<>();
        int signature = InputService.getRandomNumberInRange(0, 1000);
        for (int i = 0; i < 10; i++) {
            String filename = "..\\my\\" +  Thread.currentThread().getName() + "__" + signature + "__" + i + ".txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                bw.write("Random string lol #" + i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            files.add(filename);
        }
        Thread.sleep((long) (((Math.random() * 2) + 1) * 1000));
        System.out.printf("%s is done%n", Thread.currentThread().getName());
        return files;
    }
}
