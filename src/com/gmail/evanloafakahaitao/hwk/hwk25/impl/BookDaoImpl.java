package com.gmail.evanloafakahaitao.hwk.hwk25.impl;

import com.gmail.evanloafakahaitao.hwk.hwk25.BookDao;
import com.gmail.evanloafakahaitao.hwk.hwk25.ClientDao;
import com.gmail.evanloafakahaitao.hwk.hwk25.connection.ConnectionService;
import com.gmail.evanloafakahaitao.hwk.hwk25.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private ClientDao clientDao;

    public BookDaoImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void save(Book book) {
        String sql = "insert into books (title, client_id) values (?, ?);";
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        sql,
                        PreparedStatement.RETURN_GENERATED_KEYS
                )) {
                    preparedStatement.setString(1, book.getTitle());
                    preparedStatement.setLong(2, book.getClient() != null ? book.getClient().getId() : null);
                    int affectedRows = preparedStatement.executeUpdate();

                    if (affectedRows == 0) {
                        throw new SQLException("Creating BOOK failed! No rows changed!");
                    }

                    try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            book.setId(resultSet.getLong(1));
                        } else {
                            throw new SQLException("Creating BOOK failed, no ID returned!");
                        }
                    }
                }
            } else throw new SQLException("No connection!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Book> getBooks() {
        String sql = "select * from books;";
        List<Book> bookList = new ArrayList<>();
        try {
            Connection connection = ConnectionService.getInstance().getConnection();
            if (connection != null) {
                try (
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sql)
                ) {
                    while (resultSet.next()) {
                        Book book = Book.newBuilder()
                                .withId(resultSet.getLong("id"))
                                .withTitle(resultSet.getString("title"))
                                .withClient(
                                        clientDao.getById(resultSet.getLong("client_id"))
                                ).build();
                        bookList.add(book);
                    }
                }
            } else throw new SQLException("No connection!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return bookList;
    }
}
