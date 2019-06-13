/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizgrades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class UserIO {
    private static Scanner sc = new Scanner(System.in);
    
    public Student getStudent() {
        Student output = new Student();
        
    }
    
    public static void printScores(ArrayList<Double> quizzes) {
        System.out.println("There are " + quizzes.size() + " quizzes entered");
        Iterator<Double> iter = quizzes.iterator();
        while(iter.hasNext()) {
            double current = iter.next();
            System.out.println(current);
        }
    }
    
    public static void printAverage(Student student) {
        System.out.printf("The average quiz score for student %s is %s.", student.getFirstName(), student.getQuizAverage());
        System.out.println("");
    }
    
    public static void printStudents(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getLastName());
        }
    }
    
    
}
