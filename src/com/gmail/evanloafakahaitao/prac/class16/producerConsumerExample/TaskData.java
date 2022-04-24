package com.gmail.evanloafakahaitao.prac.class16.producerConsumerExample;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskData {

    private final Deque<String> data = new ArrayDeque<>();

    public String getData() {
        synchronized (data) {
            try {
                if (data.isEmpty()) {
                    data.wait(1500);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return data.poll();
        }
    }

    void putData(String s) {
        synchronized (data) {
            data.add(s);
            data.notify();
        }
    }
}
