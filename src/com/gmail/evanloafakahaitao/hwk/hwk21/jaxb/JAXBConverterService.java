package com.gmail.evanloafakahaitao.hwk.hwk21.jaxb;

import com.gmail.evanloafakahaitao.hwk.hwk19.task4.TaskFourService;
import com.gmail.evanloafakahaitao.hwk.hwk21.Books;
import com.gmail.evanloafakahaitao.hwk.hwk21.TaskFourBookService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBConverterService {

    public void marshall(Books books) {
        try {
            File file = new File("src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk21\\catalog_new.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(books, file);
            marshaller.marshal(books, System.out);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    public Books unmarshall(String path) {
        Books books = null;
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            books = (Books) unmarshaller.unmarshal(file);
            TaskFourBookService.analyzeBooks(books);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return books;
    }
}
