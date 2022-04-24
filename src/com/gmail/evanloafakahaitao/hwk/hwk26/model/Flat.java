package com.gmail.evanloafakahaitao.hwk.hwk26.model;

import java.util.Objects;

public class Flat {

    private Long id;
    private String size;
    private Integer countOfRooms;
    private Integer floor;
    private boolean isPopulated;
    private House house;

    public  Flat() {}

    private Flat(Builder builder) {
        setId(builder.id);
        setSize(builder.size);
        setCountOfRooms(builder.countOfRooms);
        setFloor(builder.floor);
        setPopulated(builder.isPopulated);
        setHouse(builder.house);
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(Integer countOfRooms) {
        this.countOfRooms = countOfRooms;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public boolean isPopulated() {
        return isPopulated;
    }

    public void setPopulated(boolean populated) {
        isPopulated = populated;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return Objects.equals(id, flat.id) &&
                Objects.equals(size, flat.size) &&
                Objects.equals(floor, flat.floor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, floor);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Flat{");
        sb.append("id=").append(id);
        sb.append(", size='").append(size).append('\'');
        sb.append(", countOfRooms=").append(countOfRooms);
        sb.append(", floor=").append(floor);
        sb.append(", isPopulated=").append(isPopulated);
        sb.append(", house=").append(house);
        sb.append('}');
        return sb.toString();
    }

    public static final class Builder {
        private Long id;
        private String size;
        private Integer countOfRooms;
        private Integer floor;
        private boolean isPopulated;
        private House house;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withSize(String val) {
            size = val;
            return this;
        }

        public Builder withCountOfRooms(Integer val) {
            countOfRooms = val;
            return this;
        }

        public Builder withFloor(Integer val) {
            floor = val;
            return this;
        }

        public Builder withIsPopulated(boolean val) {
            isPopulated = val;
            return this;
        }

        public Builder withHouse(House val) {
            house = val;
            return this;
        }

        public Flat build() {
            return new Flat(this);
        }
    }
}
