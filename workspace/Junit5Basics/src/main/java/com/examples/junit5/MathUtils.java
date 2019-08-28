package com.examples.junit5;

public class MathUtils {

    public int add(int a, int b) {
        return a+b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public  double divide(int a, int b) {
        return a/b;
    }

    public double computeCircleArea(int radius) {
        return Math.PI * radius * radius;
    }


}
