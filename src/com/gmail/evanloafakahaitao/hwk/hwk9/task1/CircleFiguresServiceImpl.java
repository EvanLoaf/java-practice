package com.gmail.evanloafakahaitao.hwk.hwk9.task1;

public class CircleFiguresServiceImpl extends FiguresService {

    private double radius;

    public CircleFiguresServiceImpl(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
