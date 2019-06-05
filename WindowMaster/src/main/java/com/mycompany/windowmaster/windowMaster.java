/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windowmaster;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class windowMaster {
    public static void main(String[] args) {
        float height;
        float width; 
        
        String stringHeight;
        String stringWidth;
        
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter the window's height:");
        stringHeight = sc.nextLine();
        System.out.println("Please enter the window's width:");
        stringWidth = sc.nextLine();
        
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        
        areaOfWindow = height * width; 
        perimeterOfWindow = 2*(height + width); 
        
        
        //prices outlined in problem prompt
        //add f's to force floats on hard coded values
        cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
        
        System.out.println("Height: " + stringHeight);
        System.out.println("Width: " +stringWidth);
        System.out.println("Area of Window: " + areaOfWindow);
        System.out.println("Perimeter of Window: " + perimeterOfWindow);
        System.out.println("Total Cost: " + cost);
    }
}
