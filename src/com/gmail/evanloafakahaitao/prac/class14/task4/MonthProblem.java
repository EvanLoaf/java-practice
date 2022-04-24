package com.gmail.evanloafakahaitao.prac.class14.task4;

import com.gmail.evanloafakahaitao.util.InputService;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MonthProblem {

    public List<MonthsInfo> createMonthsList() {
        List<MonthsInfo> months = new ArrayList<>();
        Locale locale = Locale.forLanguageTag("ru");
        for (int i = 0; i < 12; i++) {
            MonthsInfo monthsInfo = new MonthsInfo(
                    Month.of(i + 1).getDisplayName(TextStyle.FULL_STANDALONE, locale),
                    Month.of(i + 1).name(),
                    i + 1
            );
            months.add(monthsInfo);
        }
        return months;
    }

    public void printRequestedMonth(List<MonthsInfo> monthsInfoList) {
        System.out.println("What number of month to print?");
        int monthNumber;
        while ((monthNumber = InputService.getNumber()) < 0 || monthNumber > 12) {
            System.out.println("Months 1-12 bruv");
        }
        int finalMonthNumber = monthNumber;
        MonthsInfo month = monthsInfoList.stream().filter(monthsInfo -> monthsInfo.getNumber() == finalMonthNumber).findFirst().get();
        System.out.println(month.toString());
    }
}
