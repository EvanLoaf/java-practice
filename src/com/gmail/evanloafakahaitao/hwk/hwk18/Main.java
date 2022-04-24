package com.gmail.evanloafakahaitao.hwk.hwk18;

import com.gmail.evanloafakahaitao.hwk.hwk18.task1.TaskOneService;
import com.gmail.evanloafakahaitao.hwk.hwk18.task2.Consumer;
import com.gmail.evanloafakahaitao.hwk.hwk18.task2.Producer;
import com.gmail.evanloafakahaitao.hwk.hwk18.task2.TaskData;
import com.gmail.evanloafakahaitao.util.InputService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        /*TaskOneService taskOneService = new TaskOneService();
        taskOneService.printLongestLines();*/

        TaskData data = new TaskData();
        System.out.println("How much to produce?");
        int production = InputService.getNumber();
        System.out.println("How many consume attempts?");
        int attempts = InputService.getNumber();
        Runnable consumer = new Consumer(data, attempts);
        Runnable producer = new Producer(production, data);

        Thread producerThread1 = new Thread(producer);
        producerThread1.setName("Producer 1");
        Thread producerThread2 = new Thread(producer);
        producerThread2.setName("Producer 2");

        Thread consumerThread1 = new Thread(consumer);
        consumerThread1.setName("Consumer 1");
        Thread consumerThread2 = new Thread(consumer);
        consumerThread2.setName("Consumer 2");

        producerThread1.start();
        producerThread2.start();

        consumerThread1.start();
        consumerThread2.start();

    }
}
