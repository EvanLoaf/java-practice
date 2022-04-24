package com.gmail.evanloafakahaitao.hwk.hwk12;

public class MyExcThrower {

    public static void myMethod() {
        String string = null;
        try {
            System.out.println(string.equals(""));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }
}
