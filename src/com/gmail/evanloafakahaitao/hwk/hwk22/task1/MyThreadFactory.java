package com.gmail.evanloafakahaitao.hwk.hwk22.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadFactory {

    private MyThreadFactory() {}

    public static class Holder {
        private static MyThreadFactory myThreadFactory = new MyThreadFactory();
    }

    public static MyThreadFactory getInstance() {
        return Holder.myThreadFactory;
    }

    public void createWriterThreads(String path, String phrase) {
        System.out.printf("How many threads to create?");
        int amountOfThreads = InputService.getNumber();
        ExecutorService executorService = Executors.newFixedThreadPool(amountOfThreads);
        for (int i = 0; i < amountOfThreads; i++) {
            Runnable writeFileThread = new WriteFileThread(String.format(path, i), phrase);
            executorService.submit(writeFileThread);
        }
        executorService.shutdown();
    }
}
