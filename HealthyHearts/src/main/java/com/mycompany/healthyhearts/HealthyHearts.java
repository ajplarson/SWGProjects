/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.healthyhearts;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 * 
 * 
 */
public class HealthyHearts {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("TARGET HEART RATE");
        System.out.println("=================\n");
        System.out.println("In order to better inform you, we must first ask for some information.");
        int age = getAge();
        int maxHeartRate = findHeartRate(age);
        
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
        //Gets the ceiling of the range and then outputs an integer from thatS
        System.out.println("Your target HR Zone is " + (int)Math.ceil(0.5*maxHeartRate) + " - " + (int)Math.ceil(0.85*maxHeartRate) + " beats per minute");
    }
    
    
    public static int getAge() {
        System.out.println("What is your age?");
        String input = sc.nextLine();
        return Integer.parseInt(input);
        
    }
    
    public static int findHeartRate(int age) {
        return 220 - age;
    }
    
    
}
