package com.gmail.evanloafakahaitao.prac.class16.producerConsumerExample;

public class Consumer implements Runnable {

    private static final int CHECK_TIME_COUNTER = 3;
    private TaskData data;
    private int checkingTime = 0;

    public Consumer(TaskData data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread started");
        String s;
        while (checkingTime < CHECK_TIME_COUNTER) {
            s = data.getData();
            if (s == null) {
                checkingTime++;
                System.out.println("Consumer timeout: " + checkingTime);
            } else {
                System.out.println("Consumer get item: " + s);
                checkingTime = 0;
            }
        }
        System.out.println("Consumer thread finished");
    }

}