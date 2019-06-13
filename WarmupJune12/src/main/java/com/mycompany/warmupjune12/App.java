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
public class App {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("blue", 3);
        shapes[1] = new Rectangle("red", 4, 2);
        shapes[2] = new Square("green", 2);
        System.out.println("Here is a bunch of information about the shapes that you entered!");
        for (int i = 0; i < shapes.length; i++) {
        System.out.printf("The shape has a color %s, an area of %s, and a perimeter of %s.\n",
                shapes[i].getColor(), shapes[i].getArea(), shapes[i].getPerimeter());
        }
    }
 
}
