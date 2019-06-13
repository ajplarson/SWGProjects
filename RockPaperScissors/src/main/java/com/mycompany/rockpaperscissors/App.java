/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rockpaperscissors;

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //declare variables
        Random r = new Random();
        int computerWins = 0;
        int playerWins = 0;
        int ties = 0;
        int rounds = 0;
        int outcome = 0;
        int playerChoice = 0;

        do {
            System.out.println("Welcome to ROCK PAPER SCISSORS!");
            System.out.println("How many rounds would you like to play?");
            rounds = getUserInput(1, 10);
            do {
                int computerChoice = r.nextInt(3) + 1;
                System.out.println("Rock, Paper, or Scissors?\n"
                        + "1 = Rock, 2 = Paper, 3 = Scissors");
                playerChoice = getUserInput(1, 3);
                outcome = whoWon(playerChoice, computerChoice);
                System.out.println("There are " + (rounds - 1) +" round(s) left.");
                switch (outcome) {
                    case 1: //playerWin
                        System.out.println("Player wins!");
                        playerWins++;
                        rounds--;
                        break;
                    case 2: //computerWin
                        System.out.println("Computer wins!");
                        computerWins++;
                        rounds--;
                        break;
                    default: //tie
                        System.out.println("It's a tie!");
                        ties++;
                        rounds--;
                        break;
                }
            } while (rounds > 0); 

            System.out.println("Thanks for playing!");
            System.out.println("Here are your career stats: ");
            System.out.println("Rounds won: " + playerWins);
            System.out.println("Rounds lost: " + computerWins);
            System.out.println("Ties: " + ties);

            System.out.println("==========================");
            //declare the winner
            if (playerWins > computerWins) {
                System.out.println("Humanity wins the day!");
            } else if (computerWins > playerWins) {
                System.out.println("The robots win!");
            } else {
                System.out.println("IT'S A TIE");
            }
        } while (playAgain("Would you like to play again? Pick [y/n]"));
        System.out.println("==================");
        System.out.println("GOODBYE");
    }

    //outputs a user specified integer between lowerbound and upperbound
    private static int getUserInput(int lowerBound, int upperBound) {
        System.out.println("Please enter a number between [" + lowerBound + "] and [" + upperBound + "]");
        String input = sc.nextLine();
        try {
            int result = Integer.parseInt(input);
            if (result > upperBound || result < lowerBound) {
                result = 0;
                System.out.println("That is out of bounds");
                System.exit(0);
                //System.out.println("Please enter a number from "+ lowerBound +" - " + upperBound +".");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number.");
            System.exit(0);
        }

        return Integer.parseInt(input);
    }

    //determines if the user wants to play again
    private static boolean playAgain(String prompt) {
        System.out.println(prompt);
        return sc.nextLine().equalsIgnoreCase("y");
    }

    //outputs a number based off of who won
    //1 for a player win, 2 for a computer win, or 3 for a tie
    private static int whoWon(int playerChoice, int computerChoice) {
        System.out.println("Rock = 1, Paper = 2, Scissors = 3");
        System.out.println("You picked: " + playerChoice);
        System.out.println("The Computer picked: " + computerChoice);
        
        //print out a user friendly phrase depending on the scenario
        if (((playerChoice == 1) && (computerChoice == 3)) || ((playerChoice == 3) && (computerChoice == 1))) {
            System.out.println("Rock SMASHES Scissors");
        }      
        else if (((playerChoice == 1) && (computerChoice == 2)) || ((playerChoice == 2) && (computerChoice == 1))) {
            System.out.println("Paper covers Rock");
        } 
        else if (((playerChoice == 2) && (computerChoice == 3)) || ((playerChoice == 3) && (computerChoice == 2))) {
            System.out.println("Scissors eviscerates Paper");
        } 
             
        //determines outcomes
        if (playerChoice == computerChoice) {//tie scenario 
            return 3;
        } else if ((playerChoice == 1 && computerChoice == 3)
                || (playerChoice == 2 && computerChoice == 1)
                || (playerChoice == 3 && computerChoice == 2)) { //player win scenario
            return 1;
        } else {
            return 2;
        }
    }

}
