/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.newrps;

import com.mycompany.newrps.players.HumanPlayer;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class Game {

    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;

    public static final int WIN = 1;
    public static final int TIE = 0;
    public static final int LOSS = -1;

    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    private int ties = 0;

    private HumanPlayer one = getPlayer("Player #1, What's your name?");
    private HumanPlayer two = getPlayer("Player #2, What's your name?");

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game g = new Game();
        g.run();
    }

    private void run() {

        for (int round = 1; round <= 3; round++) {
            System.out.println("Round #" + round);

            int pickOne = one.shoot();
            int pickTwo = two.shoot();

            System.out.printf("%s chose %s.", one.getName(), translate(pickOne));
            System.out.printf("%s chose %s.", two.getName(), translate(pickTwo));

            switch (getResult(pickOne, pickTwo)) {
                case -1:
                    System.out.println(two.getName() + " WON!");
                    playerTwoWins++;
                    break;
                case 0:
                    System.out.println("IT'S A TIE");
                    ties++;
                    break;
                case 1:
                    System.out.println(one.getName() + " WON!");
                    playerOneWins++;
                    break;
                default:
                    System.out.println("That's wrong.");
                    break;
            }

        }
    }

    private HumanPlayer getPlayer(String msg) {
        System.out.println(msg);
        HumanPlayer player = new HumanPlayer(scanner.nextLine());
        return player;
    }

    private String translate(int pick) {
        switch (pick) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
        }
        return "INVALID";
    }

    //relative to playerOne
    private int getResult(int pickOne, int pickTwo) {
        if (pickOne == pickTwo) {
            return TIE;
        } else if ((pickOne == ROCK && pickTwo == SCISSORS)
                || (pickOne == PAPER && pickTwo == ROCK)
                || (pickOne == SCISSORS && pickTwo == PAPER)) {
            return WIN;
        } else {
            return LOSS;
        }
    }

}
