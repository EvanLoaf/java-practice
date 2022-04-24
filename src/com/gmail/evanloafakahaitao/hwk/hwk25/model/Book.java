package com.gmail.evanloafakahaitao.hwk.hwk25.model;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private Long id;
    private String title;
    private Client client;

    public Book() {}

    private Book(Builder builder) {
        setId(builder.id);
        setTitle(builder.title);
        setClient(builder.client);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", client=").append(client);
        sb.append('}');
        return sb.toString();
    }


    public static final class Builder {
        private Long id;
        private String title;
        private Client client;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withClient(Client val) {
            client = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
