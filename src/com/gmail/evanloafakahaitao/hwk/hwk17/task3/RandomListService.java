package com.gmail.evanloafakahaitao.hwk.hwk17.task3;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;

public class RandomListService {

    public List<String> generateList(int amountOfLines, int amountOfNumbersInLine) {
        List<String> numbersList = new ArrayList<>();
        for (int i = 0; i < amountOfLines; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < amountOfNumbersInLine; j++) {
                line.append(InputService.getRandomNumberInRange(0, 50));
                if (j < amountOfNumbersInLine - 1) line.append(",");
            }
            numbersList.add(line.toString());
        }
        return numbersList;
    }
}
