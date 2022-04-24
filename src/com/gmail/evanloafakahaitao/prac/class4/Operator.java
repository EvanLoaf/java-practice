package com.gmail.evanloafakahaitao.prac.class4;

public class Operator {

    public static void main(String[] args) {
        checkEvenOdd(3);
        checkEvenOdd(4);
        checkEvenOdd(5);

        closerToTen(100, 200);
        closerToTen(5, 15);
        closerToTen(-50, -5);
        closerToTen(-4, 22);

        checkIfNumInRange(33, 5,100);
        checkIfNumInRange(333, 5,100);
        checkIfNumInRange(100, 5,100);
    }

    public static void checkEvenOdd(int a) {
        String result = a % 2 == 0 ? "even" : "odd";
        System.out.println("Number " + a + " is " + result);
    }

    public static void closerToTen(int a, int b) {
        int diff1 = Math.abs(a - 10);
        int diff2 = Math.abs(b - 10);
        if (diff1 < diff2) {
            System.out.println("Number " + a + " is closer to 10 than number " + b);
        } else if (diff1 > diff2) {
            System.out.println("Number " + b + " is closer to 10 than number " + a);
        } else System.out.println("Numbers " + a + " and " + b + " are similarly close to 10");
    }

    public static void checkIfNumInRange(int number, int minRange, int maxRange) {
        if (number >= minRange && number <= maxRange) {
            System.out.println("Number " + number + " is within range " + minRange + " to " + maxRange);
        } else System.out.println("Number " + number + " is not in range " + minRange + " to " + maxRange);
    }
}
