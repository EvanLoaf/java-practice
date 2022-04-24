package com.gmail.evanloafakahaitao.hwk.hwk21;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(propOrder = {"author", "title", "genre", "price", "publishDate", "description"})
public class Book {

    private String id;
    private String title;
    private String description;
    private String author;
    private String genre;
    private Date publishDate;
    private float price;

    public Book() {}

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    @XmlElement
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    @XmlElement(name = "publish_date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public float getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
