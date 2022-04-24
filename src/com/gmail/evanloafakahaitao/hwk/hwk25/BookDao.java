package com.gmail.evanloafakahaitao.hwk.hwk25;

import com.gmail.evanloafakahaitao.hwk.hwk25.model.Book;

import java.util.List;

public interface BookDao {

    void save(Book book);

    List<Book> getBooks();
}
