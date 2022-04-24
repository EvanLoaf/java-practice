package com.gmail.evanloafakahaitao.prac.class6;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(number);
        }
    }
}
