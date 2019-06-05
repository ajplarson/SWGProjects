/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pairprogramming2;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        //declare variables
        Scanner sc = new Scanner(System.in);
        int userNumber;
        int sum = 0;
        String userNumberString = "";
        String s1 = "end";
        
        System.out.println("Add up any numbers! Type 'end' at any time to stop.");
        
       while (!(userNumberString.equals(s1)))
        {
            System.out.println("Next Number to Add??");
            userNumberString = sc.nextLine();
            if (userNumberString.equals(s1)) {
                break;
            }
            userNumber = Integer.parseInt(userNumberString);
            sum += userNumber;
        } 
        
       System.out.println("The sum of the numbers entered was: " + sum);
    }
}
