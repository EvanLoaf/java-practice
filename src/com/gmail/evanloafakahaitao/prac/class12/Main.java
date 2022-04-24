package com.gmail.evanloafakahaitao.prac.class12;

import com.gmail.evanloafakahaitao.util.InputService;

import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        NPEPrac.throwingNPE();

        try {
            throw new MyException("OLOLO");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        try {
            NPEPrac.throwingUncheckedExc();
        } catch (MyException e) {
            System.out.println("Handling method with THROWS in main");
            System.out.println(e.getMessage());
        }

        System.out.println("ENTER DAY TO CHECK ENUM");
        String day = InputService.getString().trim().toUpperCase();
        Days enumDay = Days.valueOf(day);
        System.out.println(enumDay);

        System.out.println("PRINTING ENUMS");
        for (Roles value : Roles.values()) {
            System.out.println(value);
            System.out.println(value.getFullInfo());
        }

        System.out.println("or foreach lambda");
        EnumSet<Roles> rolesEnumSet = EnumSet.allOf(Roles.class);
        rolesEnumSet.forEach(roles -> System.out.println(roles.getDescription()));
    }
}
