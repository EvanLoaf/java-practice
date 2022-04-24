package com.gmail.evanloafakahaitao.util;

import java.util.Random;
import java.util.Scanner;

public class InputService {

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static int getNumber() {
        System.out.println("Gimme a number");
        return sc.nextInt();
    }

    public static String getString() {
        System.out.println("Gimme a string");
        sc.skip("(\r\n|[\n\r\\u2028\\u2029\\u0085])?");
        return sc.nextLine();
    }

    public static int getRandomNumber() {
        return rd.nextInt();
    }

    public static int getRandomNumberInRange(int min, int max) {
        return rd.nextInt(max - min + 1) + min;
    }
}
