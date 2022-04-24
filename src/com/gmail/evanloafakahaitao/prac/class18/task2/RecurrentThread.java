package com.gmail.evanloafakahaitao.prac.class18.task2;

public class RecurrentThread implements Runnable {

    private static final int MAX_THREADS = 50;
    private int threadNumber;

    public RecurrentThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Thread" + threadNumber);
        if (threadNumber < MAX_THREADS) {
            Runnable runnable = new RecurrentThread(threadNumber + 1);
            Thread myThread = new Thread(runnable);
            myThread.start();
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Hi from %s ^_^%n", Thread.currentThread().getName());
    }
}
