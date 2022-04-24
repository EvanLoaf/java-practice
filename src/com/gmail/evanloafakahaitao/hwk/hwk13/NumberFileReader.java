package com.gmail.evanloafakahaitao.hwk.hwk13;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class NumberFileReader {

    public List<Integer> readNumbersFromFile(Path file) {
        List<Integer> numberList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(file.toString()))) {
            Integer number;
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                System.out.println("xd" + number);
                numberList.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberList;
    }

    public int findMax(List<Integer> integerList) {
        return integerList.stream().max(Comparator.comparingInt(a -> a)).orElseThrow(NoSuchElementException::new);
    }
}
