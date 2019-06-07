/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.noodling;

import java.util.Random;

/**
 *
 * @author ajplarson
 */
public class App1 {
    public static void main(String[] args) {
        
        
        Random r = new Random();
        String[] values = new String[1000];
        values[r.nextInt(values.length)] = "Nut";
        
        int currentIndex = 0;
        
        for(String value : values) {
            if(value != null && value.equals("Nut")) {
                System.out.println("Found it at: " + currentIndex);
            }
            currentIndex++;
        }
        
        
        
        
        
        
//        int [][] numbers = new int[10][10];
//        Random r = new Random();
//        for(int[] oneD: numbers) {
//            for(int i = 0; i < oneD.length; i++) {
//                oneD[i] = r.nextInt(Integer.MAX_VALUE);
//            }
//        }
//        for(int[] oneD: numbers) {
//            for(int value: oneD) {
//                System.out.print(value + ",");
//            }
//            System.out.println("");
//        }
        
        
    }
    static int[] removeAt(int[] values, int index) {
        if(values != null && index < values.length){ //avoid null reference exception
            
            int[] result = new int[values.length - 1];
            int currentIndex = 0;
            for(int i = 0; i < values.length; i++) {
                if(i != index) {
                   result[currentIndex] = values[i]; 
                   currentIndex++;
                }
            }
            return result;
        }
        return values; //return unedited
    }   
}
