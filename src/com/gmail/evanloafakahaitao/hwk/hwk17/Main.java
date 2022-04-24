package com.gmail.evanloafakahaitao.hwk.hwk17;

import com.gmail.evanloafakahaitao.hwk.hwk17.task3.BatchProcessingThread;
import com.gmail.evanloafakahaitao.hwk.hwk17.task3.RandomListService;
import com.gmail.evanloafakahaitao.hwk.hwk17.task3.WriterService;
import com.gmail.evanloafakahaitao.hwk.hwk17.task3.WriterThread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);

        /*String path = "..\\my\\adresses.txt";
        Runnable fileUrlWriter = new FileUrlWriter(path);
        pool.execute(fileUrlWriter);

        Callable<Long> fileLengthCallable = new FileUrlParserToFile(path);
        Future<Long> longFuture = pool.submit(fileLengthCallable);
        try {
            System.out.printf("Result from callable, File length : %d", longFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        /*List<Future<Integer>> futures = new ArrayList<>();
        Callable<Integer> callable = new NumberGeneratorAndFindMax();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(callable);
            futures.add(future);
        }
        List<Integer> maxNumbers = new ArrayList<>();
        for (Future<Integer> future : futures) {
            try {
                maxNumbers.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        Double avg = maxNumbers.stream().mapToDouble(Integer::doubleValue).average().orElse(Double.NaN);
        System.out.printf("avg max number from threads: %f", avg);*/


        int amountOfLines = 1000;
        int amountOfNumbersInLine = 4;
        int packageSize = 10;
        File numbersFile = new File("..\\numbers.txt");

        RandomListService listService = new RandomListService();
        List<String> numberList = listService.generateList(amountOfLines, amountOfNumbersInLine);

        Runnable writerThread = new WriterThread(numbersFile, numberList);
        pool.execute(writerThread);

        Callable<Integer> callable = new BatchProcessingThread(numbersFile, packageSize);
        Future<Integer> future = pool.submit(callable);

        try {
            System.out.println("Max sum = " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        pool.shutdown();
    }
}
