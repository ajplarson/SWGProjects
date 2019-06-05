/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adder;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class adderWithInput {
    public static void main(String[] args) {
        //***why can't we do one line declaration?
        //initialize variables to 0
        int sum = 0;
        int operand1 = 0;
        int operand2 = 0;
        
        //initialize a scanner
        Scanner myScanner = new Scanner(System.in);
        
        String stringOperand1 = "";
        String stringOperand2 = "";
        
        System.out.println("Please enter the first number to be added:");
        stringOperand1 = myScanner.nextLine();
        
        System.out.println("Please enter the second number to be added:");
        stringOperand2=myScanner.nextLine();
        
        //parseInt to convert to numbers
        operand1 = Integer.parseInt(stringOperand1);
        operand2 = Integer.parseInt(stringOperand2);
        
        sum = operand1 + operand2;
        
        System.out.println("Sum is: " + sum);

        
        
    }
}
