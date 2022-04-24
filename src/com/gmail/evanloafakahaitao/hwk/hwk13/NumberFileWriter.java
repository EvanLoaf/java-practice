package com.gmail.evanloafakahaitao.hwk.hwk13;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumberFileWriter {

    public boolean createFile(String path) {
        File file = new File(path);
        boolean success = false;
        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public void writeNumbers(String path) {
        System.out.println("How many numbers to write?");
        int quantity = InputService.getNumber();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            int number;
            for (int i = 0; i < quantity; i++) {
                System.out.println("What number to write?");
                number = InputService.getNumber();
                bw.write(String.valueOf(number));
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
