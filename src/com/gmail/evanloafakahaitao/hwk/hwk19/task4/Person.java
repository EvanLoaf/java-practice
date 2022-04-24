package com.gmail.evanloafakahaitao.hwk.hwk19.task4;

public class Person {

    private String name;
    private String surname;
    private int birthYear;

    private Person(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        birthYear = builder.birthYear;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static final class Builder {
        private String name;
        private String surname;
        private int birthYear;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withSurname(String val) {
            surname = val;
            return this;
        }

        public Builder withBirthYear(int val) {
            birthYear = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthYear=").append(birthYear);
        sb.append('}');
        return sb.toString();
    }
}
