package com.gmail.evanloafakahaitao.hwk.hwk17;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class NumberGeneratorAndFindMax implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return generateNumbersFindMax();
    }

    public Integer generateNumbersFindMax() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(InputService.getRandomNumberInRange(0, 100));
        }
        int max = integerList.stream().max(Comparator.comparing(i -> i)).get();
        int supamax = Collections.max(integerList);
        System.out.println("Max : " + supamax);
        return supamax;
    }
}
