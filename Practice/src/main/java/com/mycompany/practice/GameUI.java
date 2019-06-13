/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practice;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class GameUI {

    static Scanner scanner = new Scanner(System.in);

    static void run() {

        do {
            String wrestlerOneName = getWrestlerName("Wrestler #1's Name: ");
            String wrestlerTwoName = getWrestlerName("Wrestler #2's Name: ");
            Game g = new Game(wrestlerOneName, wrestlerTwoName);
            runGame(g);
            
            
        } while (keepPlaying());

        System.out.println("Goodbye");

    }

    private static boolean keepPlaying() {
        System.out.println("Play again? [y/n]");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    private static String getWrestlerName(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();

    }

    private static void runGame(Game game) {
        
        do {
           game.executeRound(); 
           
        } while(!game.isOver());
        
    }

}
