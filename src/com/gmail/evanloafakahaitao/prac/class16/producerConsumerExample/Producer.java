package com.gmail.evanloafakahaitao.prac.class16.producerConsumerExample;

public class Producer implements Runnable {

    private final TaskData data;
    private final int count;

    public Producer(TaskData data, int count) {
        this.data = data;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("Producer thread started");
        try {
            for (int i = 0; i < count; ++i) {
                data.putData("produced - " + i);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Producer thread finished");
    }
}