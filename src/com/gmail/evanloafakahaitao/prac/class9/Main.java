package com.gmail.evanloafakahaitao.prac.class9;

public class Main {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 4);
        System.out.println(rect.area());
        System.out.println(rect.perimeter());

        Circle circle = new Circle(10);
        System.out.println(circle.area());
        System.out.println(circle.perimeter());

        ArrayCreator arrayCreator = new ArrayCreator(20);
        int minElement = arrayCreator.minArrayElement(arrayCreator.createArray());
        System.out.println(minElement);

        DifferentArrayCreator differentArrayCreator = new DifferentArrayCreator(30);
        int anotherMinElement = differentArrayCreator.minArrayElement("XAXAXA");
        System.out.println(anotherMinElement);
    }
}
