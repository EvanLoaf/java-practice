package com.gmail.evanloafakahaitao.hwk.hwk17.task3;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

public class WriterThread implements Runnable {

    private File numbersFile;
    private List<String> numbersList;

    public WriterThread(File numbersFile, List<String> numbersList) {
        this.numbersFile = numbersFile;
        this.numbersList = numbersList;
    }

    @Override
    public void run() {
        WriterService writerService = new WriterService(numbersFile);
        writerService.writeFile(numbersList);
    }
}
