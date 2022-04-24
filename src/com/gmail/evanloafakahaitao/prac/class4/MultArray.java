package com.gmail.evanloafakahaitao.prac.class4;

public class MultArray {

    public static void main(String[] args) {
        int[][] multArray = new int[5][];
        multArray[0] = new int[]{2, 4, 6, 8, 10};
        multArray[1] = new int[]{4};
        multArray[2] = new int[]{6};
        multArray[3] = new int[]{8};
        multArray[4] = new int[]{10};

        for (int i : multArray[0]) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i < multArray.length; i++) {
            System.out.println(multArray[i][0]);
        }

        int[] a = {2, 4, 6, 8, 10};
        int[] b = {4};
        int[] c = {6};
        int[] d = {8};
        int[] e = {10};

        int[][] ints = new int[5][];
        ints[0] = a;
        ints[1] = b;
        ints[2] = c;
        ints[3] = d;
        ints[4] = e;

        System.out.print(ints[0][0]);
        System.out.print(" ");
        System.out.print(ints[0][1]);
        System.out.print(" ");
        System.out.print(ints[0][2]);
        System.out.print(" ");
        System.out.print(ints[0][3]);
        System.out.print(" ");
        System.out.println(ints[0][4]);
        System.out.println(ints[1][0]);
        System.out.println(ints[2][0]);
        System.out.println(ints[3][0]);
        System.out.println(ints[4][0]);
    }
}
