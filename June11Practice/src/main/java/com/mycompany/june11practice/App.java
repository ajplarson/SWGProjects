/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.june11practice;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {

    static Scanner sc = new Scanner(System.in);
    private static final int NUMBER_OF_PLAYERS = 5;
    
    
    public static void main(String[] args) {
        hockeyPlayer[] players = new hockeyPlayer[NUMBER_OF_PLAYERS];
        int index;
        System.out.println("We are building a roster of " + NUMBER_OF_PLAYERS + " players");
        
        do {
            
            System.out.println("Please enter a position in the roster: ");
            index = Integer.parseInt(sc.nextLine());

            if(index >= 1 && index<= NUMBER_OF_PLAYERS) {
            players[index-1] = addPlayer();
            }
            else {
                System.out.println("That is an invalid position.\nTry adding a new player?");
            }
            
        } while(isAdding());
        printPlayers(players);
        System.out.println("Thanks for playing!");
    }
    
    //add's a hockey player with user specified values
    private static hockeyPlayer addPlayer() {
        hockeyPlayer newPlayer = new hockeyPlayer();
        
        System.out.println("Please enter a name: ");
        newPlayer.setName(sc.nextLine());        
        System.out.println("Please enter a weight (in kg): ");
        newPlayer.setWeight(Double.parseDouble(sc.nextLine()));
        while(newPlayer.getWeight() <= 10 || newPlayer.getWeight() >= 200) {
            System.out.println("That's not a very reasonable weight.");
            System.out.println("Please enter a new weight (between 10 and 200 kg)");
            newPlayer.setWeight(Double.parseDouble(sc.nextLine()));
        }
        
        System.out.println("Please enter a height (in m): ");
        newPlayer.setHeight(Double.parseDouble(sc.nextLine()));
        while(newPlayer.getHeight() >= 3 || newPlayer.getHeight() <= 1) {
            System.out.println("That's not a very reasonable height.");
            System.out.println("Please enter a new height (between 1 and 3 meters)");
            newPlayer.setHeight(Double.parseDouble(sc.nextLine()));
        }
        
        return newPlayer;
    }
    
    //loop and input to decide whether or not to keep adding players
    private static boolean isAdding() {
        System.out.println("1. Add a hockey Player\n"
                + "2. Quit");
        String input = sc.nextLine();
        int a = Integer.parseInt(input);
        if (a == 1) {
            return true;
        }
        else if (a == 2) {
            return false;
        }
        else {
            System.out.println("Please enter a 1 to add another player or 2 to quit");
            return true;
        } 
    }
    //prints out the players if they exist or empty if that element is null
    private static void printPlayers(hockeyPlayer[] players) {
        for (int i = 0; i < players.length; i++) {
            if(players[i] == null) {
                System.out.println("Position number " + (i+1) + ".");
                System.out.println("===================");
                System.out.println("Empty\n");
            }
            else {
            System.out.println("Position number " + (i+1) + ".");
            System.out.println("===================");
            System.out.println("Name: " + players[i].getName());
            System.out.println("Height: " + players[i].getHeight() + " meters.");
            System.out.println("Weight: " + players[i].getWeight() + " kg.");
            System.out.println("");
            }
        }
    }

}
