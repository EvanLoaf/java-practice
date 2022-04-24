package com.gmail.evanloafakahaitao.prac.class14;

import com.gmail.evanloafakahaitao.prac.class14.task1.ApplesProblem;
import com.gmail.evanloafakahaitao.prac.class14.task2.CountSymbolsInStringProblem;
import com.gmail.evanloafakahaitao.prac.class14.task3.ArrayMinElementProblem;
import com.gmail.evanloafakahaitao.prac.class14.task4.MonthProblem;
import com.gmail.evanloafakahaitao.prac.class14.task4.MonthsInfo;
import com.gmail.evanloafakahaitao.prac.class14.task5.UniqueSymbolsInStringService;
import com.gmail.evanloafakahaitao.prac.class14.task6.StringIOService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task1\n");
        ApplesProblem applesProblem = new ApplesProblem();
        applesProblem.solveApplesProblem();


        System.out.println("Task2\n");
        CountSymbolsInStringProblem countSymbolsInStringProblem = new CountSymbolsInStringProblem();
        countSymbolsInStringProblem.countingSymbolsInString();


        System.out.println("Task3\n");
        ArrayMinElementProblem arrayMinElementProblem = new ArrayMinElementProblem();
        arrayMinElementProblem.findAvgOfNegativeElementsAndReplaceMinElement();


        System.out.println("Task4\n");
        MonthProblem monthProblem = new MonthProblem();
        List<MonthsInfo> monthsInfos = monthProblem.createMonthsList();
        monthProblem.printRequestedMonth(monthsInfos);


        System.out.println("Task5\n");
        UniqueSymbolsInStringService uniqueSymbolsInStringService = new UniqueSymbolsInStringService();
        uniqueSymbolsInStringService.countSymbolsInString();


        System.out.println("Task6\n");
        String path = "..\\students_kr.txt";
        StringIOService stringIOService = new StringIOService();
        stringIOService.writeStudentsToFile(path);
        System.out.println("before change");
        System.out.println(stringIOService.readStudents(path));
        stringIOService.changeStudent(path);
        System.out.println("after change");
        System.out.println(stringIOService.readStudents(path));
    }
}
