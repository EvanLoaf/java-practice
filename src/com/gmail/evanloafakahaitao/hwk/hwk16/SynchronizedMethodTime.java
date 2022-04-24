package com.gmail.evanloafakahaitao.hwk.hwk16;

import java.time.LocalDateTime;

public class SynchronizedMethodTime implements Runnable {

    @Override
    public void run() {
        myMethod();
    }

    public synchronized void myMethod() {
        Thread current = Thread.currentThread();
        System.out.printf("%s, Time - %s, Nano - %d%n", current.getName(), LocalDateTime.now(), System.nanoTime());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
