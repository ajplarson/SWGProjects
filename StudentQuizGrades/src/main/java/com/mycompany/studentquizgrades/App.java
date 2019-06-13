/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizgrades;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Double> quizScores = new ArrayList<>();
        Student jeb = new Student("Jeb", "Jones", quizScores);
        for(int i = 0; i < 5; i++) {
            quizScores.add(i, (double)r.nextInt(100));
        }
        System.out.println("The average is: " + jeb.findAverage(quizScores));
    }
  
}
