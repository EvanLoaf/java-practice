package com.gmail.evanloafakahaitao.prac.class9;

public class Rectangle extends Figure {

    private double length;
    private double height;

    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public double area() {
        return length * height;
    }

    @Override
    public double perimeter() {
        return 2 * length + 2 * height;
    }
}
