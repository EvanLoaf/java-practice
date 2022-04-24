package com.gmail.evanloafakahaitao.prac.class8;

public class Student extends Man {

    private int year;

    public Student(String name, int age, String sex, int weight, int year) {
        super(name, age, sex, weight);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void skipYear() {
        this.year += 1;
    }

}
