package com.gmail.evanloafakahaitao.prac.class11;

import java.util.HashMap;

public class HashMapPrac {

    public static void main(String[] args) {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("Apple", "Fruit");
        stringHashMap.put("Sofa", "Furniture");
        stringHashMap.put("Work", "Relax");
        stringHashMap.put("Light", "Sun");
        stringHashMap.put("Cat", "Kitten");
        stringHashMap.put("Cow", "Milk");
        stringHashMap.put("Rain", "Water");

        stringHashMap.forEach((k, v) -> System.out.println(k + " | " + v + "\n"));
        System.out.println("Pairs : " + stringHashMap.size());
        System.out.println("Contains key Light? " + stringHashMap.containsKey("Light"));
        System.out.println("Remove Cow-Milk : " + stringHashMap.remove("Cow", "Milk"));
        System.out.println("Remove Work-Morework : " + stringHashMap.remove("Work", "Morework"));
        System.out.println("Remove Darkness-Sun : " + stringHashMap.remove("Darkness", "Sun"));
        stringHashMap.forEach((k, v) -> System.out.println(k + " | " + v + "\n"));


    }
}
