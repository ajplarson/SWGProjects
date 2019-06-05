/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.morningcodejune4;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        int meaningOfLife = 42;
        double pi = 3.1415926535897932384626;
        String cheese, color;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Give me pi");
        pi = inputReader.nextDouble();
        
        System.out.println("What is the meaning of life?");
        meaningOfLife = inputReader.nextInt();
        System.out.println("Favorite type o cheese?");
        inputReader.next();
        System.out.println("Favourite colour? ");
        inputReader.next();
        
        System.out.println("Pi: " + pi +"\nMeaning of Life" + meaningOfLife);
        
        
    }
}
