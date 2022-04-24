package com.gmail.evanloafakahaitao.hwk.hwk22.task2;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PlayerTaskService {

    private PlayerTaskService() {}

    private static class Holder {
        private static PlayerTaskService playerTaskService = new PlayerTaskService();
    }

    public static PlayerTaskService getInstance() {
        return Holder.playerTaskService;
    }

    public List<String> generatePlayers() {
        System.out.println("How mkany threads to run?");
        int numOfThreads = InputService.getNumber();
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        List<String> fileList = new ArrayList<>();
        List<Future<String>> futureList = new ArrayList<>();
        System.out.println("How many players to generate?");
        int number = InputService.getNumber();
        Callable<String> callable = new PlayerGeneratorTask(number);
        for (int i = 0; i < numOfThreads; i++) {
            Future<String> future = executorService.submit(callable);
            futureList.add(future);
        }
        for (Future<String> future : futureList) {
            try {
                fileList.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return fileList;
    }

    public List<Player> readAndSortPlayers(List<String> files) {
        ExecutorService executor = Executors.newFixedThreadPool(files.size());
        List<Player> matureActivePlayersFromAllFiles = new ArrayList<>();
        List<Future<List<Player>>> playersFutures = new ArrayList<>();
        for (String file : files) {
            Callable<List<Player>> callable = new PlayerReaderTask(file);
            Future<List<Player>> future = executor.submit(callable);
            playersFutures.add(future);
        }
        for (Future<List<Player>> playersFuture : playersFutures) {
            try {
                matureActivePlayersFromAllFiles.addAll(playersFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return matureActivePlayersFromAllFiles;
    }
}
