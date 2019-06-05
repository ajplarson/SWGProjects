/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conversation;

import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class Conversation {
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String name, color, food, pet, number;
        int counter = 0;
        
        System.out.println("Before we get started, I need to collect some information from you");
        
        System.out.println("Name?");
        name = sc.nextLine();
        
        System.out.println("Favorite color?");
        color = sc.nextLine();
        
        System.out.println("Favorite food?");
        food = sc.nextLine();
        
        System.out.println("Any pets? If so, type which kind");
        pet = sc.nextLine();
        
        System.out.println("Favorite number?");
        number = sc.nextLine();
                System.out.println("Hello " + name + "\nLet's see what we learned about you");
                System.out.println("I hate " + color + "!\nJust Kidding!!");
                System.out.println("Mmmmm... " + "I love " + food + "!");
                System.out.println("So you have a " + pet + "?\nInteresting!");
                System.out.println("Your favorite number is: " + number); 
        
    }
}
