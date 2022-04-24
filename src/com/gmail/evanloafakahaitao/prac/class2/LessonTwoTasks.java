package com.gmail.evanloafakahaitao.prac.class2;

import com.gmail.evanloafakahaitao.util.InputService;

public class LessonTwoTasks {

    public static void main(String[] args) {
        System.out.println("Java forever");
        InputService inputService = new InputService();
        int result = gigaCalc(inputService.getNumber(), inputService.getNumber());
        System.out.println(result);
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int mult(int a, int b) {
        return a * b;
    }

    private static int gigaCalc(int a, int b) {
        return  sum(a, b) + mult(a, b);
    }

}
