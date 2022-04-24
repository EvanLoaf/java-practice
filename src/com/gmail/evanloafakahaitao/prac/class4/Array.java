package com.gmail.evanloafakahaitao.prac.class4;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.Arrays;
import java.util.Comparator;

public class Array {

    public static void main(String[] args) {
        String[] strArr = new String[10];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = "value" + InputService.getRandomNumberInRange(1, 50);
        }
        System.out.println(strArr[strArr.length - 1]);
        int[] intArr = new int[10];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = InputService.getRandomNumberInRange(1, 50);
        }
        int[] sortedIntArr = Arrays.stream(intArr).boxed().sorted(Comparator.naturalOrder())
                                                            .mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < sortedIntArr.length; i++) {
            String info = (i % 2 == 0) ? "even" + sortedIntArr[i] : "odd";
            System.out.println(info);
        }
    }
}
