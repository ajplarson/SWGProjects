/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.warmupjune12;

/**
 *
 * @author ajplarson
 */
public class Circle extends Shape {

    private static final double PI = 3.1415926535;
    private double radius;

    public Circle(String color, double radius) {
        super(color); //adding in a color that is required by the parent class Shape
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
