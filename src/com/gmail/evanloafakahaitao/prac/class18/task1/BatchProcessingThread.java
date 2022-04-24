package com.gmail.evanloafakahaitao.prac.class18.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BatchProcessingThread implements Callable<Integer> {

    private List<Integer> integerList;
    private int batchSize;

    public BatchProcessingThread(List<Integer> integerList, int batchSize) {
        this.integerList = integerList;
        this.batchSize = batchSize;
    }

    @Override
    public Integer call() throws Exception {
        List<Future<Integer>> futureList = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Integer> subList = new ArrayList<>(batchSize);
        for (int i = 1; i <= integerList.size(); i++) {
            subList.add(integerList.get(i - 1));
            if (i % batchSize == 0) {
                Callable<Integer> callable = new MaxNumberThread(subList);
                Future<Integer> future = pool.submit(callable);
                futureList.add(future);
                subList = new ArrayList<>(batchSize);
            }
        }

        pool.shutdown();

        int maxNumber = 0;
        if (!futureList.isEmpty()) {
            for (Future<Integer> future : futureList) {
                int number = future.get();
                maxNumber = Math.max(maxNumber, number);
            }
            return maxNumber;
        }

        return null;
    }
}
