package com.gmail.evanloafakahaitao.prac.class8;

public class Main {

    public static void main(String[] args) {
        Student lexa = new Student("Lexa", 20, "male", 70, 3);
        System.out.println(String.format("Ima student. Name: %s, year: %d", lexa.getName(), lexa.getYear()));
    }
}
