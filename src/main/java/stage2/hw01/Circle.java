package stage2.hw01;

import java.util.Scanner;

public class Circle implements Measurable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}

interface Measurable {
    double area();
}
