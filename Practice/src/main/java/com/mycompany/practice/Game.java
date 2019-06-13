/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practice;

import java.util.Random;

/**
 *
 * @author ajplarson
 */
public class Game {

    public static final Random RAND = new Random();

    public Game(String nameOne, String nameTwo) {
        wrestlerOne = new Wrestler(nameOne);
        wrestlerTwo = new Wrestler(nameTwo);
    }
    private final Wrestler wrestlerOne;
    private final Wrestler wrestlerTwo;

    boolean isOver() {
        return wrestlerOne.isDefeated() || wrestlerTwo.isDefeated();
    }

    void executeRound() {
        Wrestler first = null;
        Wrestler second
        if (RAND.nextBoolean()) {
            System.out.println(wrestlerOne.getName() + " goes first.");
            int staminaDrain = wrestlerOne.attack();
            wrestlerTwo.decreaseStamina(staminaDrain);
            System.out.printf("%s does %s damage, %s is at %s stamina.\n",
                    wrestlerOne.getName(),
                    staminaDrain,
                    wrestlerTwo.getName()),
                    wrestlerTwo.getStamina()
            );
            staminaDrain = wrestlerTwo.attack();
            wrestlerOne.decreaseStamina(staminaDrain);
        } else {
                        System.out.println(wrestlerTwo.getName() + " goes first.");

            int staminaDrain = wrestlerTwo.attack();
            wrestlerOne.decreaseStamina(staminaDrain);
            staminaDrain = wrestlerOne.attack();
            wrestlerTwo.decreaseStamina(staminaDrain);

        }
    }
}
