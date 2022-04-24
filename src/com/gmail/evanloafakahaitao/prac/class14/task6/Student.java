package com.gmail.evanloafakahaitao.prac.class14.task6;

public class Student {

    private int number;
    private String firstName;
    private String lastName;
    private int mathsMark;
    private int physicsMark;
    private int chemistryMark;

    public Student(int number, String firstName, String lastName, int mathsMark, int physicsMark, int chemistryMark) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mathsMark = mathsMark;
        this.physicsMark = physicsMark;
        this.chemistryMark = chemistryMark;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMathsMark() {
        return mathsMark;
    }

    public void setMathsMark(int mathsMark) {
        this.mathsMark = mathsMark;
    }

    public int getPhysicsMark() {
        return physicsMark;
    }

    public void setPhysicsMark(int physicsMark) {
        this.physicsMark = physicsMark;
    }

    public int getChemistryMark() {
        return chemistryMark;
    }

    public void setChemistryMark(int chemistryMark) {
        this.chemistryMark = chemistryMark;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(number).append(" ").append(firstName).append(" ").append(lastName).append(" ").append(mathsMark).
                append(" ").append(physicsMark).append(" ").append(chemistryMark);
        return sb.toString();
    }
}
