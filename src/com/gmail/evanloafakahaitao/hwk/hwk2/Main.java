package com.gmail.evanloafakahaitao.hwk.hwk2;

import com.gmail.evanloafakahaitao.util.InputService;

public class Main {

    public static void main(String[] args) {
        System.out.println(avg(InputService.getNumber(), InputService.getNumber(), InputService.getNumber()));
        motivation();
        System.out.println(calc(InputService.getNumber(), InputService.getNumber()));
    }

    public static double avg(int a, int b, int c) {
        return (a + b + c) / 3d;
    }

    public static void motivation() {
        System.out.println("I can do it epta");
    }

    public static int calc(int x, int y) {
        int i;
        i = x;
        i *= y;
        i += x;
        i += y;
        return i;
    }
}
