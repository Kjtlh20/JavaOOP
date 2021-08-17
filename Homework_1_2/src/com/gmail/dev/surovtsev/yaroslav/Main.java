package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(2.0, 2.0, 2.0);
        Triangle triangle2 = new Triangle(5.0, 10.0, 11.0);
        System.out.println(triangle1);
        System.out.println("S1: " + triangle1.getSquare());
        System.out.println(triangle2);
        System.out.println("S2: " + triangle2.getSquare());
        triangle2.setSideA(6.0);
        System.out.println(triangle2);
        System.out.println("S2: " + triangle2.getSquare());
    }
}
