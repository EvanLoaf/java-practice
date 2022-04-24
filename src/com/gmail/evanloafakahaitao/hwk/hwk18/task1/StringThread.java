package com.gmail.evanloafakahaitao.hwk.hwk18.task1;

import com.gmail.evanloafakahaitao.hwk.hwk17.task3.RandomListService;

import java.util.List;
import java.util.concurrent.Callable;

public class StringThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        RandomLineService randomLineService = new RandomLineService();
        return randomLineService.generateString();
    }
}
