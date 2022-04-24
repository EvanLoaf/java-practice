package com.gmail.evanloafakahaitao.hwk.hwk18.task2;

public class Consumer implements Runnable {

    private final TaskData data;
    private int attempts;

    public Consumer(TaskData data, int attempts) {
        this.data = data;
        this.attempts = attempts;
    }

    @Override
    public void run() {
        int checkingTime = 0;
        System.out.printf("Consumer %s STARTING%n", Thread.currentThread().getName());
        Integer receiverNumber;
        while (checkingTime < attempts) {
            receiverNumber = data.getData();
            if (receiverNumber == null) {
                checkingTime++;
                System.out.println("Consumer timeout " + checkingTime);
            } else {
                checkingTime = 0;
                System.out.printf("Received Data by %s = %d%n", Thread.currentThread().getName(), receiverNumber);
            }
            System.out.println();
        }

        System.out.printf("Consumer %s FINISHED%n", Thread.currentThread().getName());
    }
}
