/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringmethods;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) {
        /* TO CHECK VOWEL COUNTER
        System.out.println("Pleae enter a word to count the vowels:");
        Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();
        int numVowels = countVowels(test);
        System.out.println("The number of vowels in " + test + " is(are) " + numVowels); 
        code to check vowel counter*/
        
        /* TO CHECK CHAR DELETER
        System.out.println("Please Enter a word.");
        String inputWord = sc.nextLine();
        
        System.out.println("Which character would you like to remove from " + inputWord + "?");
        String toRemove = sc.nextLine();
        
        char removeMe = toRemove.charAt(0);
        
        String output = removeCharacter(inputWord, removeMe);
        System.out.println("Your new word is: " + output); */
        Scanner sc = new Scanner(System.in);
    }

    public static int countVowels(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'e' || str.charAt(i) == 'u') {
                counter++;
            }
        }
        return counter;
    }

    public static String removeCharacter(String inputWord, char removeMe) {
        
        StringBuilder sb = new StringBuilder(inputWord);
        for (int i = 0; i < sb.length(); i++) {
            if (removeMe == sb.charAt(i)) {
                sb.deleteCharAt(i);
            }
        }
        String resultString = sb.toString();
        return resultString;
    }
    /*
    public static boolean containsNumbers(String inputWord, int number) {
        for(int i = 0; i < inputWord.length; i++) {
            if(inputWord[i])
        }
    }
    
    
    /*
    public static String repeatString(String inputWord, int numberOfTimes) {

    }

    public static String makeVowelsUppercase(String inputWord) {

    }   */
}
