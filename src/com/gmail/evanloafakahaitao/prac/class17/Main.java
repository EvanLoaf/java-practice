package com.gmail.evanloafakahaitao.prac.class17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        /*List<Future<List<String>>> futureList = new ArrayList<>();
        Callable<List<String>> callable = new FireWriterService();
        for (int i = 0; i < 10; i++) {
            Future<List<String>> future = executor.submit(callable);
            futureList.add(future);
        }
        for (Future<List<String>> future : futureList) {
            try {
                future.get().forEach(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/

        /*List<Future<String>> stringFutureList = new ArrayList<>();
        Callable<String> stringCallable = new NumberSumService();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executor.submit(stringCallable);
            stringFutureList.add(future);
        }
        for (Future<String> future : stringFutureList) {
            try {
                System.out.printf("Sum of numbers : %s%n", future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/

        /*List<Future<String>> datetimeFutureList = new ArrayList<>();
        Callable<String> datetimeCallable = new MessageWriterService();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executor.submit(datetimeCallable);
            datetimeFutureList.add(future);
        }
        for (Future<String> future : datetimeFutureList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/

        Callable<String> datetimeCallable = new MessageWriterService();
        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callables.add(datetimeCallable);
        }
        List<Future<String>> futures = new ArrayList<>();
        try {
             futures.addAll(executor.invokeAll(callables));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        executor.shutdown();
    }
}
