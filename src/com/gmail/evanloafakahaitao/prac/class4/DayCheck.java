package com.gmail.evanloafakahaitao.prac.class4;

public class DayCheck {

    public static void main(String[] args) {
        System.out.println(dayChecker(2));
        System.out.println(dayChecker(5));
        System.out.println(dayChecker(0));
        System.out.println(dayChecker(22));
    }

    public static String dayChecker(int dayIndex) {
        switch (dayIndex) {
            case 0: return "alkogolizm v pn";
            case 1: return "alkogolizm vo vt";
            case 2: return "alkogolizm v sr";
            case 3: return "alkogolizm v cht";
            case 4: return "alkogolizm v pt";
            case 5: return "alkogolizm v sb";
            case 6: return "alkogolizm v vos";
            default: return "xz";
        }
    }
}
