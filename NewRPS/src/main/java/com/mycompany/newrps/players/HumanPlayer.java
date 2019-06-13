/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.newrps.players;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class HumanPlayer {

    private static final String VALIDATION_MSG = "Enter a valid number [1-3].";

    private Scanner scanner = new Scanner(System.in);
    private String name;

    public HumanPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int shoot() {
        int result = 0;
        do {
            System.out.println("Pick.");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            try {
                result = Integer.parseInt(scanner.nextLine());
                if (result < 1 || result > 3) {
                    System.out.println(VALIDATION_MSG);
                }

            } catch (NumberFormatException ex) {
                System.out.println(VALIDATION_MSG);
            }
        } while (result <= 0 || result > 3);
        return result;

    }
}
