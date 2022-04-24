package com.gmail.evanloafakahaitao.prac.class9;

public class Trapezium extends Figure {

    private double a;
    private double b;
    private double h;
    private double c;
    private double d;

    public Trapezium(double a, double b, double h, double c, double d) {
        this.a = a;
        this.b = b;
        this.h = h;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return (a + b) / 2 * h;
    }

    @Override
    public double perimeter() {
        return a + b + c + d;
    }
}
