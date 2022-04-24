package com.gmail.evanloafakahaitao.hwk.hwk4;

import com.gmail.evanloafakahaitao.prac.class4.Array;
import com.gmail.evanloafakahaitao.util.InputService;

import java.util.Arrays;

public class ArrayOperatorCyclePrac {

    public static void main(String[] args) {
        int[] arr1 = new int[4];
        int[] arr2 = new int[4];
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 4;
        }
        System.arraycopy(arr1,0, arr3, 0, arr1.length);
        System.arraycopy(arr2,0, arr3, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr3));

        leapYear(2300);
        leapYear(2400);
        leapYear(2333);
        leapYear(2024);

        season(2);
        season(0);

        arrGenAndIncr(10, 1);
        arrGenAndIncr(3, 0);

        arrSumBeforeAfterElement(5, 5);
        arrSumBeforeAfterElement(5, 20);
        arrSumBeforeAfterElement(500, 69);
        arrSumBeforeAfterElement(500, 69);

        showSecondMaxElement(new int[] {1, 5, 7, 3, 2});
        showSecondMaxElement(arrGen(10));

        arrayMatchingElements(new int[] {5, 10, 20, -3, 2, -8}, new int[] {100, 200, 300, 400, 500, 600});
        arrayMatchingElements(arrGen(3), arrGen(3));
        arrayMatchingElements(arrGen(1), arrGen(1));

    }

    public static void leapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                System.out.println("Not a leap year");
            } else System.out.println("Leap year");
        } else System.out.println("Not a leap year");
    }

    public static void season(int a) {
        switch (a) {
            case 1:
                System.out.println("Winter");
                break;
            case 2:
                System.out.println("Spring");
                break;
            case 3:
                System.out.println("Summer");
                break;
            case 4:
                System.out.println("Fall");
                break;
                default:
                    System.out.println("xz");
        }
    }

    public static int[] arrGen(int length) {
        int[] myArray = new int[length];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = InputService.getRandomNumberInRange(1, 100);
        }
        return myArray;
    }

    public static void arrGenAndIncr(int arrLength, int elemNo) {
        if (arrLength - elemNo < 1) {
            throw new Error("Range exceeded. Array length < required index");
        } else {
            int[] myArray = arrGen(arrLength);
            System.out.println("Chosen number: " + myArray[elemNo]);
            myArray[elemNo] *= 1.1;
            System.out.println("Now Chosen number is bigger (if not rounded or negative): " + myArray[elemNo]);
        }
    }

    public static void arrSumBeforeAfterElement(int arrLength, int elemValue) {
        int[] myArray = arrGen(arrLength);
        int indexCounter = 0;
        for (int i : myArray) {
            if (i == elemValue) {
                int sumBefore = 0, sumAfter = 0;
                for (int j = 0; j < indexCounter; j++) {
                    sumBefore += myArray[j];
                }
                for (int k = indexCounter + 1; k < myArray.length; k++) {
                    sumAfter += myArray[k];
                }
                System.out.println("Match found!");
                System.out.println("Sum before: " + sumBefore);
                System.out.println("Sum after: " + sumAfter);
                return;
            }
            indexCounter ++;
        }
        System.out.println("Match was not found :(");
    }

    public static void showSecondMaxElement(int[] intArray) {
        Arrays.sort(intArray);
        System.out.println("second largest number lmao: " + intArray[intArray.length - 2]);
    }

    public static void arrayMatchingElements(int[] firstArray, int[] secondArray) {
        int firstArraySmallestElementIndex = 0;
        int smallerElementsCounter;
        int stopFlag = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (stopFlag == 1) break;
            smallerElementsCounter = 0;
            for (int j = 0; j < firstArray.length; j++) {
                if (firstArray[j] < firstArray[i]) {
                    smallerElementsCounter++;
                }
                if (j == firstArray.length - 1 && smallerElementsCounter < 1) {
                    stopFlag++;
                    firstArraySmallestElementIndex = i;
                }
            }
        }
        System.out.println("1st array smallest elem index: " + firstArraySmallestElementIndex
                        + "\n2nd Array elem with index " + firstArraySmallestElementIndex + " is "
                        + secondArray[firstArraySmallestElementIndex]);

    }

}
