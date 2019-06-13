/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dnawarmup;

import java.util.Random;

/**
 *
 * @author ajplarson
 */
public class DNAWarmup {

    private static final int LENGTH = 10;

    public static void main(String[] args) {
        String testString = randomString(LENGTH);
        System.out.println("The original strand of DNA is: " + testString);
        System.out.println("The transcribed strand of DNA is: " + transcribeDNA(testString));
    }

    private static String randomString(int length) {
        String options = "atcg";
        StringBuilder output = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            output.append(options.charAt(r.nextInt(4)));
        }

        return output.toString();
    }

    private static String transcribeDNA(String strand) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < strand.length(); i++) {
            char test = strand.charAt(i);
            switch (test) {
                case 'a':
                    output.append('t');
                    break;
                case 't':
                    output.append('a');
                    break;
                case 'c':
                    output.append('g');
                    break;
                case 'g':
                    output.append('c');
                    break;
                default:
                    break;
            }
        }
        return output.toString();
    }
}
