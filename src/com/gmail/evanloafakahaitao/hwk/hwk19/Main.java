package com.gmail.evanloafakahaitao.hwk.hwk19;


import com.gmail.evanloafakahaitao.hwk.hwk19.task1.ReaderFactory;
import com.gmail.evanloafakahaitao.hwk.hwk19.task1.TextReader;
import com.gmail.evanloafakahaitao.hwk.hwk19.task3.ListFactory;
import com.gmail.evanloafakahaitao.hwk.hwk19.task4.Person;
import com.gmail.evanloafakahaitao.hwk.hwk19.task4.TaskFourService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TextReader reader1 = ReaderFactory.getInstance().getReader(ReaderFactory.ReaderTypes.TXT);
        TextReader reader2 = ReaderFactory.getInstance().getReader(ReaderFactory.ReaderTypes.XML);
        TextReader reader3 = ReaderFactory.getInstance().getReader(ReaderFactory.ReaderTypes.PROPERTIES);
        reader1.read();
        reader2.read();
        reader3.read();

        ListFactory.getInstance().getList(ListFactory.ListType.LINKED_LIST);

        TaskFourService taskFourService = new TaskFourService();
        List<Person> personList = taskFourService.generatePersons();
        taskFourService.printOlderToYounger(personList);
    }
}
