package com.gmail.evanloafakahaitao.prac.class14.task4;

import java.util.Objects;
import java.util.stream.Stream;

public class MonthsInfo {

    private String russianName;
    private String engName;
    private int number;

    public MonthsInfo(String russianName, String engName, int number) {
        this.russianName = russianName;
        this.engName = engName;
        this.number = number;
    }

    public String getRussianName() {
        return russianName;
    }

    public String getEngName() {
        return engName;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MonthsInfo{");
        sb.append("russianName='").append(russianName).append('\'');
        sb.append(", engName='").append(engName).append('\'');
        sb.append(", number=").append(number);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthsInfo that = (MonthsInfo) o;
        return number == that.number &&
                Objects.equals(russianName, that.russianName) &&
                Objects.equals(engName, that.engName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(russianName, engName, number);
    }
}
