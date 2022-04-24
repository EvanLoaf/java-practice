package com.gmail.evanloafakahaitao.hwk.hwk25.service;

import com.gmail.evanloafakahaitao.hwk.hwk25.model.Book;
import com.gmail.evanloafakahaitao.hwk.hwk25.model.Client;

import java.util.ArrayList;
import java.util.List;

public class GeneratorService {

    private static GeneratorService generatorService;

    public static GeneratorService getInstance() {
        if (generatorService == null) {
            generatorService = new GeneratorService();
        }
        return generatorService;
    }

    public List<Book> generateBooksWithClients() {
        List<Book> bookListWithClients = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Client client = Client.newBuilder()
                    .withName("supername" + i)
                    .build();
            for (int j = 0; j < 5; j++) {
                Book book = Book.newBuilder()
                        .withTitle("book" + i)
                        .withClient(client)
                        .build();
                bookListWithClients.add(book);
            }
        }
        return bookListWithClients;
    }
}
