/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palindromecheck;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        
    }
    
    private static String reverseString(String input) {
        int j = input.length();
        char[] charactersInString = new char[input.length()];
        
        //loop to write into an array
        for (int i = 0; i < input.length(); i++) {
            charactersInString[i] = input.charAt(i);
        }
        //loop to reverse
        for(int i = 0; i < input.length(); i++) {
            charactersInString[i] = charactersInString[j];
            j--;
        }
        return input;
    }
 
}
