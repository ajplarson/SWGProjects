/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorizor;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    
    
    public static int[] calculateFactors(int numberToBeFactored) {
        int[] factors = new int[50]; 
        int i = 0;
        for (int number = 1; number <= (numberToBeFactored/2); number++) {
            if(numberToBeFactored % number == 0) {
                factors[i] = number;
                i++;
            }
        }
        return factors;
    }
    
    
    public static void isPerfect(int input, int sumOfFactors) {
        if (input == sumOfFactors) {
            System.out.println(input + " is a perfect number.");
        }
        else {
            System.out.println(input + " is not a perfect number.");
        }
    }
    
    public static void isPrime(int input, int counterFromFactors) {
        
    }
    
    public static void main(String[] args) {
        
        //initialize variables
        int inputNumber = 0;
        int sum = 0;
        int counterOfFactors = 0;
        int[] factors = new int[50];
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What number would you like to factor?");
        inputNumber = sc.nextInt();
        factors = calculateFactors(inputNumber);
        
        System.out.println("Here are your factors");
        for (int i = 0; i <= (inputNumber/2); i++) {
            if(factors[i] != 0) {
                sum += factors[i];
                counterOfFactors++;
                System.out.println(factors[i]);
            }
        }
        
        
        isPerfect(inputNumber, sum);
        if (counterOfFactors <= 1) {
            System.out.println(inputNumber + " is a prime number.");
        }
        else {
            System.out.println(inputNumber + " is not a prime number.");
        }
        
    }
    
    
}
