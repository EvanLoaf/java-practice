package com.gmail.evanloafakahaitao.hwk.hwk21;

import java.util.List;

public class TaskFourBookService {

    public static void analyzeBooks(Books books) {
        List<Book> bookList = books.getBookList();
        if (bookList != null) {
            float priceSum = 0;
            for (Book book : bookList) {
                priceSum += book.getPrice();
            }
            System.out.println("avg price : " + priceSum / bookList.size());
        }
        System.out.println("Num of books : " + bookList.size());
    }
}
