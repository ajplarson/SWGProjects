/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threecardmonte;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int wallet = 500000;
        System.out.println("You currently have: $" + wallet);
        Random r = new Random();

        do {
            int bet = getBet("How much would you like to bet?");
            if (bet > wallet) {
                System.out.println("You don't have that much money.");
                System.out.println("You can't play again.");
                break;
            }
            wallet -= bet;
            if (runGame(r)) {
                wallet += 2*bet;
                System.out.println("You won!\n");
                System.out.println("You now have: $" + wallet);
            }
            else {
                System.out.println("You LOST\n");
                System.out.println("You now have: $" + wallet);
            }

        } while ((readBoolean("Play Again? Pick [y/n]")) && (wallet > 0));

    }

    
    private static boolean runGame(Random r) {
        int correctCard = r.nextInt(3);
        int guessCard = getUserCard();
        if (guessCard == correctCard) {
            return true;
        }
        else {
            return false;
        }
    }
    private static boolean readBoolean(String prompt) {
        System.out.println(prompt);
        return sc.nextLine().equalsIgnoreCase("y");
    }

    
    
    private static int getUserCard() {
        int result = 0;

        do {
            System.out.println("Please pick a card. [1-3]");
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
    
    
    private static int getBet(String prompt) {
        System.out.println(prompt);
        String output = sc.nextLine();
        return Integer.parseInt(output);
    }

}
