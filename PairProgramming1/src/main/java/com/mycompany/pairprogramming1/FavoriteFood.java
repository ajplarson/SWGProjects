/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pairprogramming1;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class FavoriteFood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String favoriteFood;
        
        System.out.println("What's your favorite food?");
        favoriteFood = sc.nextLine();
        
        System.out.println("Your favorite food is " + favoriteFood + "? " + "My favorite food is that too!");
        
        
    }
}
