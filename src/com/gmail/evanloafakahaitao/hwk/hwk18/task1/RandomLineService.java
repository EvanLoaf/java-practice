package com.gmail.evanloafakahaitao.hwk.hwk18.task1;

import com.gmail.evanloafakahaitao.util.InputService;

public class RandomLineService {

    public String generateString() {
        int length = InputService.getRandomNumberInRange(5, 10);
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int symbol = InputService.getRandomNumberInRange(1, 3);
            switch (symbol) {
                case 1: stringBuilder.append("b");
                    break;
                case 2: stringBuilder.append("v");
                    break;
                case 3: stringBuilder.append("x");
                    break;
                default: stringBuilder.append(0);
            }
        }
        return stringBuilder.toString();
    }
}
