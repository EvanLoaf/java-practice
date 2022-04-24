package com.gmail.evanloafakahaitao.hwk.hwk21;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "catalog")
public class Books {

    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    @XmlElement(name = "book")
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Books{");
        sb.append("bookList=").append(bookList);
        sb.append('}');
        return sb.toString();
    }
}
