package com.gmail.evanloafakahaitao.prac.class18;

import com.gmail.evanloafakahaitao.prac.class18.task1.BatchProcessingThread;
import com.gmail.evanloafakahaitao.prac.class18.task1.ListService;
import com.gmail.evanloafakahaitao.prac.class18.task2.RecurrentThread;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        int amountOfNumbers = 100;
        int batchSize = 10;

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<List<Integer>> callable = new ListService(amountOfNumbers);
        Future<List<Integer>> future = executor.submit(callable);
        List<Integer> integerList = new ArrayList<>();
        try {
            integerList = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Callable<Integer> integerCallable = new BatchProcessingThread(integerList, batchSize);
        Future<Integer> integerFuture = executor.submit(integerCallable);
        try {
            int maxNumber = integerFuture.get();
            System.out.println("Max Max number = " + maxNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        ExecutorService pool = Executors.newSingleThreadExecutor();
        Runnable recurrentThread = new RecurrentThread(1);
        pool.execute(recurrentThread);
        pool.shutdown();

        listDrivers();
    }

    private static void listDrivers() {
        Enumeration driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("   "+driverClass.getClass().getName());
        }
    }
}
