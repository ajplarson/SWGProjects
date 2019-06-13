/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.summativesums;

/**
 *
 * @author ajplarson
 */
public class SummativeSums {

    public static void main(String[] args) {
        //declaring the 3 test arrays
        int[] testArrayOne = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] testArrayTwo = {999, -60, -77, 14, 160, 301};
        int[] testArrayThree = {10, 20, 30, 40, 50, 60, 70, 80, 90,
            100, 110, 120, 130, 140, 150, 160, 170,
            180, 190, 200, -99};

        //printing the outcome
        System.out.println("#1 Array Sum: " + sumArray(testArrayOne));
        System.out.println("#2 Array Sum: " + sumArray(testArrayTwo));
        System.out.println("#3 Array Sum: " + sumArray(testArrayThree));

    }

    //finds the sum of an array
    public static int sumArray(int[] numbers) {

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }

}
