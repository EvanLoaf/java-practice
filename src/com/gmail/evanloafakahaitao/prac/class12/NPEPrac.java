package com.gmail.evanloafakahaitao.prac.class12;

public class NPEPrac {

    public static void throwingNPE() {
        try {
            throw new NullPointerException("GG");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }

    public static void throwingUncheckedExc() throws MyException {
        throw new MyException("XD");
    }
}
