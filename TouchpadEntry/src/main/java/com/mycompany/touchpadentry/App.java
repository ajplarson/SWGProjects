/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.touchpadentry;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        
        //initialize our password for the door
        int passcodeOne = 1;
        int passcodeTwo = 0;
        int passcodeThree = 1;
        int passcodeFour = 0;
        
        //initialize the user's guess
        int guessOne, guessTwo, guessThree, guessFour;
        
        //initialize scanner and other variables we will use
        Scanner sc = new Scanner(System.in);
        
        
        do {
            System.out.println("Welcome to the Novel Coworking Space!\nPlease enter the 4-digit passcode");
            
            System.out.println("What is the first digit?");
            guessOne = sc.nextInt();
            if (guessOne == passcodeOne) {
                System.out.println("What is the second digit?");
                guessTwo = sc.nextInt();
                if (guessTwo == passcodeTwo) {
                    System.out.println("What is the third digit?");
                    guessThree = sc.nextInt();
                    if (guessThree == passcodeThree) {
                        System.out.println("What is the fourth digit?");
                        guessFour = sc.nextInt();
                        if (guessFour == passcodeFour) {
                            System.out.println("Password accepted.\nPlease Enter.");
                            break;
                        }   
                    }
                }
            }         
        } while(true);
        
    }
    
}
