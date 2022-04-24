package com.gmail.evanloafakahaitao.hwk.hwk19.task2;

import java.util.List;

public class Course {

    private List<String> students;
    private String name;
    private int price;
    private boolean isCompleted;
    private int numberOfLessons;

    private Course(Builder builder) {
        students = builder.students;
        name = builder.name;
        price = builder.price;
        isCompleted = builder.isCompleted;
        numberOfLessons = builder.numberOfLessons;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public List<String> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }


    public static final class Builder {
        private List<String> students;
        private String name;
        private int price;
        private boolean isCompleted;
        private int numberOfLessons;

        private Builder() {
        }

        public Builder withStudents(List<String> val) {
            students = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withPrice(int val) {
            price = val;
            return this;
        }

        public Builder withIsCompleted(boolean val) {
            isCompleted = val;
            return this;
        }

        public Builder withNumberOfLessons(int val) {
            numberOfLessons = val;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
