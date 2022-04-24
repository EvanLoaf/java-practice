package com.gmail.evanloafakahaitao.hwk.hwk16;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteNumbersToFileService {

    public void writeNumbersToFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (int i = 0; i < 10; i++) {
                bw.write(String.valueOf(InputService.getRandomNumberInRange(0, 10)) + " from " + Thread.currentThread().getName());
                bw.newLine();
            }
            System.out.println(Thread.currentThread().getName() + " finished writing to its file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
