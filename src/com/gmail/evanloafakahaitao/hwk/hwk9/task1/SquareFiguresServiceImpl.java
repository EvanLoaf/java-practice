package com.gmail.evanloafakahaitao.hwk.hwk9.task1;

public class SquareFiguresServiceImpl extends FiguresService {

    private double a;
    private double b;

    public SquareFiguresServiceImpl(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double perimeter() {
        return (a + b) * 2;
    }
}
