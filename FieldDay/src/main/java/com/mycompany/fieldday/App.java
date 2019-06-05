/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fieldday;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lastName;
        
        System.out.println("Please Enter Your Last Name: ");
        lastName = sc.nextLine();
        char letter = lastName.charAt(0); 
        int asciiName = Character.getNumericValue(letter);
    
        while(true) {
            if (asciiName < 10) {
                System.out.println("Please enter a number.");
                break;
            }
            else if (asciiName < 12) {
                System.out.println("You are on team Red Dragons!");
                break;
            }
            else if (asciiName == 12) {
                System.out.println("You are on team Dark Wizards!");
                break;
            }
            else if (asciiName < 17) {
                System.out.println("You are on team Moving Castles!");
                break;
            }
            else if (asciiName < 25) {
                System.out.println("You are on team Golden Snitches");
                break;
            }
            else if (asciiName < 31) {
                System.out.println("You are on team Night Guards!");
                break;
            }
            else {
                System.out.println("You are on team Black Holes");
                break;
            }
        }
        System.out.println("Best of Luck to you " + lastName + "\nMay the best team win!");
    }

    
    
}
