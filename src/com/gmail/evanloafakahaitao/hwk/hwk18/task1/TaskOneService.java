package com.gmail.evanloafakahaitao.hwk.hwk18.task1;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskOneService {

    public void printLongestLines() {
        System.out.println("How many threads and string to generate?");
        int amount = InputService.getNumber();
        ExecutorService executorService = Executors.newFixedThreadPool(amount);
        Callable<String> callable = new StringThread();

        List<Future<String>> futureList = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            Future<String> future = executorService.submit(callable);
            futureList.add(future);
        }

        int longestString = -1;
        for (Future<String> future : futureList) {
            try {
                int length = future.get().length();
                longestString = Math.max(longestString, length);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("longest string = " + longestString);

        for (Future<String> future : futureList) {
            try {
                if (future.get().length() == longestString) {
                    System.out.println(future.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
