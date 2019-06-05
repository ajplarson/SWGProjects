/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessinggame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rGen = new Random();
        int guess = 0;
        int counter = 1;
        int delta;
        int rInt = rGen.nextInt(100) + 1;
        System.out.println("Think you can guess a number between 1 and 100? Give it a shot!");
        while (true) {
            
            
            System.out.println("Enter a number:");
            guess = Integer.parseInt(sc.nextLine());
            delta = Math.abs(rInt - guess);
            if (guess == rInt) {
                System.out.println("YAY!!! YOU DID IT!\n" + "You had to guess " + counter + " times. Better luck next time?");
                break;
            }
            else if(delta <= 5) {
                System.out.println("Super close!! Try again.");
                if (guess > rInt) {
                    System.out.println("Try a little lower!");
                    counter++;
                }
                else {
                    System.out.println("Try a little higher!");
                    counter++;
                }
            }
                
            else if (guess > rInt) {
                System.out.println("Nope. This time, try guessing LOWER\n");
                counter++;
            }
            else if (guess < rInt) {
                System.out.println("Nope. This time, try guessing HIGHER\n");
                counter++;
            }
        }
    }
}
