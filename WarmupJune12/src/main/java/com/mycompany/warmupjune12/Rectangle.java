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
public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color); //takes a color from the parent class
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return (2 * length + 2 * width);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

}
