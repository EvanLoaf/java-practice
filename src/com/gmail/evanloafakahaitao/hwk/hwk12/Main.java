package com.gmail.evanloafakahaitao.hwk.hwk12;

import com.gmail.evanloafakahaitao.util.InputService;

public class Main {

    static boolean amIFree = false;

    public static void main(String[] args) {
        MyExcThrower.myMethod();

        do {
            try {
                mySuperMethod();
            } catch (ExceptionOfFire | ExceptionOfWater | ExceptionOfWind e) {
                System.out.println(String.format("Danger! %s!", e.getClass()));
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Wow, weird input");
                System.out.println(e.getMessage());
            } finally {
                System.out.println("ah, cmon, is it over yet");
            }
        } while (!amIFree);



        MediaBox mediaBox = new MediaBox(Volume.MEDIUM);
        System.out.println(mediaBox.getVolume().getDescription());
        mediaBox.increaseVolume();
        System.out.println(mediaBox.getVolume().getDescription());
        mediaBox.increaseVolume();
        System.out.println(mediaBox.getVolume().getDescription());
        mediaBox.lowerVolume();
        System.out.println(mediaBox.getVolume().getDescription());
        mediaBox.lowerVolume();
        System.out.println(mediaBox.getVolume().getDescription());
        mediaBox.lowerVolume();
        System.out.println(mediaBox.getVolume().getDescription());

    }

    public static void mySuperMethod() throws RuntimeException {
        System.out.println("Hey, i need a number 1 to 3 (or 0 xd)");
        int number = InputService.getNumber();
        switch (number) {
            case 1: throw new ExceptionOfWater("input 1");
            case 2: throw new ExceptionOfFire("input 2");
            case 3: throw new ExceptionOfWind("input 3");
            case 0:
                System.out.println("gz, u're free now");
                amIFree = true;
                break;
            default: throw new RuntimeException("xz che vveli");
        }
    }
}
