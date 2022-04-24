package com.gmail.evanloafakahaitao.prac.class5;

public class CyclesPrac {

    public static void main(String[] args) {
        oddSum(new double[]{1, 2, 3, 4.4, 5.5, 6.6, 7 , 8 , 9});
        oddSumInRange(1, 10);
        numbersInRangePrinter(25, 50);
        incrementor( 77);

    }

    public static void oddSum(double[] numbers) {
        int sum = 0;
        for (double number : numbers) {
            if (number % 1 == 0 && number % 2 == 1) sum += number;
        }
        System.out.println("Sum of odd integer numbers: " + sum);
    }

    public static void oddSumInRange(int start, int end) {
        int sum = 0;
        if (start % 2 == 0) start++;
        while (start <= end) {
            sum += start;
            start += 2;
        }
        System.out.println("Sum of odd integer numbers: " + sum);
    }

    public static void numbersInRangePrinter(int start, int end) {
        int range = end - start;
        for (int i = 0; i < range; i++) {
            if (start % 2 == 1) {
                System.out.println(start);
            } else System.out.println(start + "!");
            start++;
        }
    }

    public static void incrementor(int number) {
        if (number < 100) {
            do {
                System.out.println(number);
                number++;
            } while (number < 100);
        } else throw new Error("INPUT TOO LARGE OMG");
    }


}
