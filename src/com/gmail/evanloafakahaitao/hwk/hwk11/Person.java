package com.gmail.evanloafakahaitao.hwk.hwk11;

import java.util.Objects;
import java.util.function.Function;

public class Person {

    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        assert isValidName(firstName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public static boolean isValidName(String firstName) {
        return firstName instanceof String && firstName.length() > 0;
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthYear);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("fN='").append(firstName).append('\'');
        sb.append(", lN='").append(lastName).append('\'');
        sb.append(", bY=").append(birthYear);
        sb.append('}');
        return sb.toString();
    }
}
