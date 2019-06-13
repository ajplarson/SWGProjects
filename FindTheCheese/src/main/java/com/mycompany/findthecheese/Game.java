/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthecheese;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
class Game {

    private static final int WORLD_SIZE = 10;
    private static final char BLANK = '_';

    private Cheese cheese;
    private Mouse mouse;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        //place mouse and cheese here.
        Random r = new Random();
        int x = r.nextInt(WORLD_SIZE);
        int y = r.nextInt(WORLD_SIZE);
        cheese = new Cheese(x, y);
        
        do {
        x = r.nextInt(WORLD_SIZE);
        y = r.nextInt(WORLD_SIZE);
        } while(x == cheese.getX() && y == cheese.getY());
        mouse = new Mouse(x, y);

    }

    void run() {
        do {
            display();
            move();
        } while (gameRunning());
        printResults();
    }

    private void display() {
        for (int row = 0; row < WORLD_SIZE; row++) {
            for (int col = 0; col < WORLD_SIZE; col++) {
                if (row == cheese.getY() && col == cheese.getX()) {
                    System.out.print(cheese.getCheeseSymbol());
                } else if (row == mouse.getY() && col == mouse.getX()) {
                    System.out.print(mouse.getMouseSymbol());
                } else {
                    System.out.print(BLANK);
                }
            }
            System.out.println("");
        }
    }

    private void move() {
        System.out.println("Move your mouse [W,A,S,D]");
        String move = scanner.nextLine();
        if (move.equalsIgnoreCase("W")) {
            mouse.moveUp();
        } else if (move.equalsIgnoreCase("A")) {
            mouse.moveLeft();
        } else if (move.equalsIgnoreCase("S")) {
            mouse.moveDown();
        } else if (move.equalsIgnoreCase("D")) {
            mouse.moveRight();
        } else {
            System.out.println("That's not a valid move.");
        }
    }

    private boolean gameRunning() {
        if (mouse.getX() == cheese.getX()
                && mouse.getY() == cheese.getY()) {
            return false;
        } else if (mouse.getX() >= WORLD_SIZE || mouse.getY() >= WORLD_SIZE
                || mouse.getX() < 0 || mouse.getY() < 0) {
            return false;
        }
        return true;
    }
    private void printResults() {
        if (mouse.getX() == cheese.getX()
                && mouse.getY() == cheese.getY()) {
            System.out.println("You win!");
        } else if (mouse.getX() >= WORLD_SIZE || mouse.getY() >= WORLD_SIZE
                || mouse.getX() < 0 || mouse.getY() < 0) {
            System.out.println("Sorry, you lose!");
        }
    }
}
