/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.noodling;

/**
 *
 * @author ajplarson
 */
public class practiceMethod {
    public static double calculatePi() {
        return 3.1415926535;
    }
    public static double areaOfCircle(double radius) {
        double pi = calculatePi();
        return pi*radius*radius;
    }
    
    
    public static void main(String[] args) {
        drawThings(100,100);
       
    }
    
    
    
    
    
    
    
    
    
    
    public static void drawThings(int maxRow, int maxCol) {
        int i = 0;
        int j = 0;

        while (i < maxRow) {
            while (j < maxCol) {
                System.out.print("*");
                j++;
            }
            j = 0;
            System.out.println("");
            i++;
        }
    }
    
    
    
    
    
    
    
}
