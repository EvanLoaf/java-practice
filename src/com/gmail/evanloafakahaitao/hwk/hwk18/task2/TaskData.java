package com.gmail.evanloafakahaitao.hwk.hwk18.task2;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskData {

    private Deque<Integer> data = new ArrayDeque<>();

    public void putData(int number) {
        synchronized (data) {
            data.add(number);
            data.notify();
        }
    }

    public Integer getData() {
        synchronized (data) {
            if (data.isEmpty()) {
                try {
                    data.wait(200);
                } catch (Exception e) {
                    System.out.println(e.getMessage());;
                }
            }
            try {
                Thread.sleep(333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return data.poll();
        }
    }

}
