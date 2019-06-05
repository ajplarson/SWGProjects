/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.elevator;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        System.out.println("THE ELEVATOR");
        System.out.println("============");
        
        int maxFloor = 4;
        
        Scanner sc = new Scanner(System.in);
        boolean isInside = false;
        int elevatorFloor = 1;
        int ourFloor = 1;
        
        String input = null; //initialize to stop static analysis from worrying
        
        
        do {
            
            System.out.printf("You are %s the elevator.\n",
                    isInside ? "inside" : "outside");
            System.out.printf("You are on floor %s.\n", ourFloor);
            System.out.printf("The elevator is on floor %s.\n", elevatorFloor);
            System.out.println("\n=============");
            if(isInside) {
                
                // pick a valid floor or Q to quit
                boolean isValid = false;
                do {
                System.out.printf("Press [1 - %s] for a floor.\n", maxFloor);
                System.out.println("Q to Quit");
                
                isValid = input.equals("Q");
                if (!isValid) {
                    for ( int floor = 1; floor <= maxFloor && !isValid; floor++) {
                        isValid = input.equals(Integer.toString(floor));
                        
                    }
                }
                } while(!isValid);
                
                //have valid input
                if (!input.equalsIgnoreCase("Q")) {
                    System.out.printf("You requested floor %s", input);
                    int requestedFloor = Integer.parseInt(input);
                    elevatorFloor = requestedFloor;
                    isInside = false;
                }
            } else {
                
                
                
                boolean isValid = false;
                do {
                    if(ourFloor == 1) {
                        System.out.println("1. Up");
                    } else if(ourFloor == maxFloor) {
                        System.out.println("1. Down");
                    } else {
                        System.out.println("1. Up");
                        System.out.println("2. Up");
                    }
                    
                    System.out.println("Q to Quit");
                    input = sc.nextLine(); 
                    isValid = input.equalsIgnoreCase("Q");
                    if(!isValid) {
                        if(ourFloor == 1 || ourFloor == maxFloor) {
                           isValid = input.equals("1");
                        } else {
                            isValid = input.equals("1") || input.equals("2");
                        }
                    }
                } while(!isValid);
                
                if(!(input.equalsIgnoreCase("Q"))) {
                    isInside = true;
                }
            }
                
            
            
        } while(!(input.equalsIgnoreCase("Q")));
        System.out.println("Thanks for playing!\nGoodbye");
    }
}
