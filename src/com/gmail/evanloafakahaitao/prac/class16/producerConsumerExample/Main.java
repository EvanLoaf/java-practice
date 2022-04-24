package com.gmail.evanloafakahaitao.prac.class16.producerConsumerExample;

public class Main {

    public static void main(String[] args) {
        int count = 20;
        TaskData data = new TaskData();
        Thread thread = new Thread(new Producer(data, count));
        thread.start();
        Thread thread1 = new Thread(new Consumer(data));
        thread1.start();
    }
}
