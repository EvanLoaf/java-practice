package com.gmail.evanloafakahaitao.hwk.hwk9.task1;

public class TriangleFiguresServiceImpl extends FiguresService {

    private double a;
    private double b;
    private double c;

    public TriangleFiguresServiceImpl(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double halfPerimeter = perimeter();
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
