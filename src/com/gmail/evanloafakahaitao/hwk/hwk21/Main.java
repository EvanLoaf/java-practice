package com.gmail.evanloafakahaitao.hwk.hwk21;

import com.gmail.evanloafakahaitao.hwk.hwk20.XMLValidatorService;
import com.gmail.evanloafakahaitao.hwk.hwk21.jaxb.JAXBConverterService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String xml = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk21\\catalog.xml";
        String xsd = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk21\\catalog.xsd";
        /*String xml = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk21\\test\\books.xml";
        String xsd = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk21\\test\\schema.xsd";*/
        System.out.println("Validating XML - XSD");
        System.out.println("Valid = " + XMLValidatorService.validateXmlAgainstSchema(xml, xsd));

        JAXBConverterService jaxbConverterService = new JAXBConverterService();
        Books books = jaxbConverterService.unmarshall(xml);
        System.out.println(books);

        Books moreBooks = new Books();
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setId("bk10" + i);
            book.setAuthor("author1" + i);
            book.setDescription("descr" + i);
            book.setGenre("School");
            book.setPrice(12.99f);
            book.setPublishDate(new Date(120, 10, 20));
            book.setTitle("title" + i);
            bookList.add(book);
        }
        moreBooks.setBookList(bookList);
        jaxbConverterService.marshall(moreBooks);
    }
}
