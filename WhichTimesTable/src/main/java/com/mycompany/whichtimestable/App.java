/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.whichtimestable;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int timesTableNumber, guess;
        int points = 0;
        System.out.println("Enter a number that you would like the times table for: ");
        timesTableNumber = sc.nextInt();
        for (int i =0; i < 11; i++) {
            System.out.println(i + " times " + timesTableNumber + " is: " );
            System.out.println("Make a guess?");
            guess = sc.nextInt();
            if (guess == (i*timesTableNumber)){
                System.out.println("You are correct! " + i + " times " + timesTableNumber + " is: " + guess + "\n");
                points++;
            }
            else {
                System.out.println("Nope! Good try. The correct answer was: " + (i*timesTableNumber) + "\n");
            }
        }
        System.out.println("Thanks for playing!\nYour score was " + points + " out of 11 points.");
    }
}
