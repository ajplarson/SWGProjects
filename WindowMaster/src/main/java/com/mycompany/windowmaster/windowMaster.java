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
        //declare variables
        float height;
        float width; 
        
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        
        height = readValue("Please enter the window's height:");
        width = readValue("Please enter the window's width:");
        
   
        areaOfWindow = areaOfRectangle(height, width);
        perimeterOfWindow = perimeterOfRectangle(height, width);
        
        //prices outlined in problem prompt
        //add f's to force floats on hard coded values
        cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
        
        System.out.println("Height: " + height);
        System.out.println("Width: " + width);
        System.out.println("Area of Window: " + areaOfWindow);
        System.out.println("Perimeter of Window: " + perimeterOfWindow);
        System.out.println("Total Cost: " + cost);
    }
    
    
    public static float readValue(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String input = sc.nextLine();
        float floatVal = Float.parseFloat(input);
        return floatVal;
    }
    
    
    public static float areaOfRectangle(float length, float width) {
        return (length*width);
    }
    
    public static float perimeterOfRectangle(float length, float width) {
        return (2*(length+width));
    }
    
    
}
