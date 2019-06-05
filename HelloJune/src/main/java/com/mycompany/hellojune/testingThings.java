/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hellojune;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class testingThings {
    public static void main(String[] args) {
        int sum = 0;
        int index = 0;
        int currentNumber = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many numbers do you want to add?");
        index = sc.nextInt() - 1;
        
        System.out.println("First number?");
        for (int i = 0; i <= index; i++) {
            if (i<index) {
                currentNumber = sc.nextInt();
                sum += currentNumber;
                currentNumber = 0;
                System.out.println("Next one?");
            }
            else {
                currentNumber = sc.nextInt();
                sum += currentNumber;
                currentNumber = 0; 
                System.out.println(currentNumber);
            }   
        }
        System.out.println("The sum is: " + sum);
    }
}
