package com.gmail.evanloafakahaitao.hwk.hwk16;

public class Main {

    public static void main(String[] args) {
        Runnable arrayService = new ArrayMaxNumberService();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(arrayService);
            thread.setName(thread.getName() + " #" + i);
            thread.start();
        }

        String path = "..\\numbers_from_threads.txt";
        WriteNumbersToFileService writeNumbersToFileService = new WriteNumbersToFileService();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> writeNumbersToFileService.writeNumbersToFile(path)).start();
        }
        
        Runnable synchMethod = new SynchronizedMethodTime();
        for (int i = 0; i < 10; i++) {
            Thread newThread = new Thread(synchMethod);
            newThread.start();
        }
    }
}
