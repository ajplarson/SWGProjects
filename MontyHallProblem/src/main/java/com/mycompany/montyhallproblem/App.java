/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.montyhallproblem;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) {
        int wins = 0;
        int losses = 0;
        Random r = new Random();
        
        do {
            if (runGame(r)) {
                wins++;
            } else {
                losses++;
            }
        } while (readBoolean("Play again? [y/n]"));

        printCareer(wins, losses);
    }

    private static boolean readBoolean(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine().equalsIgnoreCase("y");    
    }

    
    
    
    
    
    
    
    
    private static boolean runGame(Random r) {
        int carDoor = r.nextInt(3);

        int userDoor = getUserDoor();
        int revealedDoor = revealGoatDoor(carDoor, userDoor, r);
        
        if(doesSwitch(revealedDoor)) {
            userDoor = 3 - (userDoor + revealedDoor);
        }
        
        //System.out.printf("Car: %s, User: %s, Reveal: %s\n", carDoor, userDoor, revealedDoor);
        
        if(userDoor == carDoor) {
            System.out.println("You Win!");
        } else {
            System.out.println("You lose");
        }
        
        return (userDoor == carDoor);
    }

    private static void printCareer(int wins, int losses) {
        System.out.println("Career Totals");
        System.out.println("=============");
        System.out.printf("Wins: %s\n", wins);
        System.out.printf("Losses: %s\n", losses);
        System.out.printf("Win Percentage %%%s", (wins / (double)(wins + losses)));
    }

    private static int getUserDoor() {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        do {
            System.out.println("Please choose a door. [1-3]");
            String choice = sc.nextLine();
            try {
                result = Integer.parseInt(choice);
                if (result > 3 || result < 1) {
                    result = 0;
                    System.out.println("Please enter 1 - 3.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        } while (result < 1);
        return result - 1;

    }

    private static int revealGoatDoor(int carDoor, int userDoor, Random r) {
        int revealedDoor = 0;
        if(carDoor == userDoor) { //they picked the car!!
            if(r.nextBoolean()) {
                revealedDoor = (carDoor + 1) % 3; //mod for wrapping
            } else {
                revealedDoor = (carDoor + 2) % 3;
            }
        } else {
            revealedDoor = 3 - (carDoor + userDoor);
        }
        return revealedDoor;
    }

    private static boolean doesSwitch(int revealedDoor) {
                System.out.printf("There's a goat behind door #%s!\n", (revealedDoor + 1));
                return readBoolean("Do you want to switch? [y/n]");
    }

}
