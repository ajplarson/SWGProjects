/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classpractice;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.setName("Spot");
        myDog.setWeight(30);
        Dog aNewDog = new Dog("Buster", 25);
    }
   
}
