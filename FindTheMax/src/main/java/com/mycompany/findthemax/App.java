/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthemax;

/**
 *
 * @author ajplarson
 */




public class App {
    
    
    public static int findMax(int[] list) {
    int max = 0;
    for (int i = 0; i < list.length; i++) {
        if (list[i] >= max) {
            max = list[i];
        }
        else if (max >= list[i]) {
            max = max;
        }
    }
    return max;
}
    
    
    
    
    public static void main(String[] args) {
      
        int[] list = {1, 2, 3, 4, 5, 2, 3};
        System.out.println("The max of this list is: " + findMax(list));
    }
}
