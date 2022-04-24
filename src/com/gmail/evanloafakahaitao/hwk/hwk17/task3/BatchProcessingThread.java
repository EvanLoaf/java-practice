package com.gmail.evanloafakahaitao.hwk.hwk17.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BatchProcessingThread implements Callable<Integer> {

    private File numbersFile;
    private int batchSize;

    public BatchProcessingThread(File numbersFile, int batchSize) {
        this.numbersFile = numbersFile;
        this.batchSize = batchSize;
    }

    @Override
    public Integer call() throws Exception {
        String line;
        List<String> stringList = new ArrayList<>(batchSize);
        List<Future<Integer>> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        synchronized (numbersFile) {
            try (BufferedReader br = new BufferedReader(new FileReader(numbersFile))) {
                int i = 0;
                while ((line = br.readLine()) != null) {
                    if (i < batchSize) {
                        stringList.add(line);
                        i++;
                    } else {
                        Callable<Integer> sumThread = new SumThread(stringList);
                        Future<Integer> future = executorService.submit(sumThread);
                        futureList.add(future);
                        stringList = new ArrayList<>(batchSize);
                        stringList.add(line);
                        i = 1;
                    }
                }
                if (!stringList.isEmpty()) {
                    Callable<Integer> sumThread = new SumThread(stringList);
                    Future<Integer> future = executorService.submit(sumThread);
                    futureList.add(future);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        executorService.shutdown();

        if (!futureList.isEmpty()) {
            int max = futureList.get(0).get();
            for (Future<Integer> future : futureList) {
                Integer element = future.get();
                max = Math.max(max, element);
            }
            return max;
        }

        return null;
    }
}
