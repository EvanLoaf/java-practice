package com.gmail.evanloafakahaitao.hwk.hwk26.model;

import java.util.Objects;

public class House {

    private Long id;
    private String address;

    public House() {}

    private House(Builder builder) {
        setId(builder.id);
        setAddress(builder.address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(id, house.id) &&
                Objects.equals(address, house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("House{");
        sb.append("id=").append(id);
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static final class Builder {
        private Long id;
        private String address;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withAddress(String val) {
            address = val;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
