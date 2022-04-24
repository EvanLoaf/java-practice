package com.gmail.evanloafakahaitao.hwk.hwk18.task2;

import com.gmail.evanloafakahaitao.util.InputService;

public class Producer implements Runnable {

    private final int amount;
    private final TaskData data;

    public Producer(int count, TaskData data) {
        this.amount = count;
        this.data = data;
    }

    @Override
    public void run() {
        System.out.printf("Producer %s STARTING%n", Thread.currentThread().getName());
        int counter = 0;
        while (counter < amount) {
            int number = InputService.getRandomNumberInRange(0, 100);
            data.putData(number);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        System.out.printf("Producer %s FINISHED%n", Thread.currentThread().getName());
    }
}
