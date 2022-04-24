package com.gmail.evanloafakahaitao.mytest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        byte b = 0x55;
        short s = 0x55ff;
        int i = 1000000;
        long l = 0xffffffffL;
        char c = 'a';
        float f = .25f;
        double d = .00001234;
        boolean bool = true;
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(c);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);
        calc(l, l);

    }

    public static void calc(float a, float b) {
        System.out.println(a + b);
    }
}
