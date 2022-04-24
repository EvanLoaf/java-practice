package com.gmail.evanloafakahaitao.hwk.hwk25;

import com.gmail.evanloafakahaitao.hwk.hwk25.connection.ConnectionService;
import com.gmail.evanloafakahaitao.hwk.hwk25.impl.BookDaoImpl;
import com.gmail.evanloafakahaitao.hwk.hwk25.impl.ClientDaoImpl;
import com.gmail.evanloafakahaitao.hwk.hwk25.model.Book;
import com.gmail.evanloafakahaitao.hwk.hwk25.service.DatabaseService;
import com.gmail.evanloafakahaitao.hwk.hwk25.service.GeneratorService;

import java.util.List;

public class LibraryApp {

    private LibraryApp() {}

    private static class Holder {
        private static final LibraryApp libraryApp = new LibraryApp();
    }

    public static LibraryApp getInstance() {
        return Holder.libraryApp;
    }

    public void run() {
        DatabaseService.createDatabase();
        DatabaseService.createClientsTable();
        DatabaseService.createBooksTable();

        List<Book> bookListWithClients = GeneratorService.getInstance().generateBooksWithClients();

        ClientDao clientDao = new ClientDaoImpl();
        BookDao bookDao = new BookDaoImpl(clientDao);

        for (Book bookWithClient : bookListWithClients) {
            if (bookWithClient.getClient().getId() == null) {
                clientDao.save(bookWithClient.getClient());
            }
            bookDao.save(bookWithClient);
        }

        List<Book> books = bookDao.getBooks();
        for (Book book : books) {
            System.out.println(book);
            System.out.println(clientDao.getById(book.getClient().getId()));
        }

        ConnectionService.getInstance().closeConnection();
    }
}
