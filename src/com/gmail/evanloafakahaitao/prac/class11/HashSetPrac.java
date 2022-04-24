package com.gmail.evanloafakahaitao.prac.class11;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetPrac {

    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        String[] strings = {"water", "ban", "water", "vish", "grush", "mel", "ezh", "zhen", "zeml", "mel", "iris", "ban", "pot"};
        for (String string : strings) {
            stringHashSet.add(string);
            stringArrayList.add(string);
        }
        System.out.println("Set : " + stringHashSet.size());
        System.out.println("List : " + stringArrayList.size());
        System.out.println("Set ||||||||||||| \n");
        stringHashSet.forEach(System.out::println);
        System.out.println("List |||||||||||| \n");
        stringArrayList.forEach(System.out::println);
        stringArrayList.forEach(System.out::println);

    }
}
