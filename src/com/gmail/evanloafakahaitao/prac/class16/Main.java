package com.gmail.evanloafakahaitao.prac.class16;


public class Main {

    public static void main(String[] args) {
        Runnable threadCalcArrayService = new ThreadCalcArrayService();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadCalcArrayService);
            thread.start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Now we done");
    }
}
