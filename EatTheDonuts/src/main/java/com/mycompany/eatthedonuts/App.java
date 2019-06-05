/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eatthedonuts;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        System.out.println("==============");
        System.out.println("EAT THE DONUTS");
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many Donuts?");
        int donuts = sc.nextInt();
        
        while (donuts > 0) {
            //printf formats, injects number into, but does not do new line
            System.out.printf("%s Donuts left.\n", donuts);
            System.out.println("Eat how many?");
            int donutsEaten = sc.nextInt();
            donuts = donuts - donutsEaten;
        }
        System.out.println("All done!");
        
    }
}
