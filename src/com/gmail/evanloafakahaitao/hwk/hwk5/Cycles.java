package com.gmail.evanloafakahaitao.hwk.hwk5;

public class Cycles {

    public static void main(String[] args) {
        dayCounter(2000, 2010);
        squareNumbers();
        divisibleNumbers();

    }

    public static void dayCounter(int startYear, int endYear) {
        int days = 0;
        for (int i = startYear; i <= endYear; i++) {
            if (i % 4 == 0) {
                days += 366;
            } else days += 365;
        }
        System.out.println(String.format("In years %d to %d there are %d days", startYear, endYear, days));
    }

    public static void squareNumbers() {
        for (int i = 10; i < 21; i++) {
            System.out.println(i * i);
        }
    }

    public static void divisibleNumbers() {
        for (int i = 20; i < 51; i++) {
            if (i % 3 == 0 && i % 5 != 0) System.out.println(i);
        }
    }
}
