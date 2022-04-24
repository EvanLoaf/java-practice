package com.gmail.evanloafakahaitao.prac.class14.task1;

import com.gmail.evanloafakahaitao.util.InputService;

public class ApplesProblem {

    public void solveApplesProblem() {
        System.out.printf("How many students?");
        int student = InputService.getNumber();
        System.out.printf("How many apples?");
        int apples = InputService.getNumber();
        if (student < 1 || apples < 1) {
            System.out.printf("Waduhek, no students or apples, ILLEGAL!");
        } else {
            System.out.printf("Every student gets %f apples%n", Math.floor(apples / student));
            System.out.printf("%d apples still in the basket!", apples % student);
        }
    }
}
