/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connectfour;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        int[][] freshBoard = new int[7][6];
        resetBoard(freshBoard);
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(freshBoard[j][i]);
            } 
            System.out.println("");
        } 
        
        
        do {
            
        } while(isWinner(false));
    }
    
    
    
    //generates a board comprised of rows and columns. 
    public static void resetBoard(int[][] array) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
            array[j][i] = 0; 
            }     
        }  
    }

    private static boolean isWinner(boolean b) {
        return false;
    }
}
