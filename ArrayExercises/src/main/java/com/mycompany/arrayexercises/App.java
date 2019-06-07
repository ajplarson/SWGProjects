/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arrayexercises;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        double[] numbers = {1.5, 2, 3, 4, 6};
        System.out.println("The array of characters is " + spitOutString("hello"));
    }
    public static double sumArray(double[] numbers) {
        double sum = 0;
        for (double i: numbers) {
            sum += i;
        }
        return sum;  
    }
    public static char[] spitOutString(String input) {
        char[] output = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            output[i] = input.charAt(i); 
        }
        
        return output;
    }
    
    public static int sumArray(int[][] numbers) {
    int sum = 0;
    
    for (int[] number : numbers) {
        for (int j : number) {
            sum += j;
        }
    }
   return sum;
  }
}
