/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizgrades;

import java.util.ArrayList;

/**
 *
 * @author ajplarson
 */
public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> quizScores;
    private double quizAverage = findAverage(quizScores);

    public Student(String firstName, String lastName, ArrayList<Double> quizScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.quizScores = quizScores;
    }
    
    public double findAverage(ArrayList<Double> quizzes) {
        double sum = 0;
        for(double quiz: quizzes) {
            sum += quiz;
        }
        return sum/quizzes.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList getQuizScores() {
        return quizScores;
    }

    public void setQuizScores(ArrayList quizScores) {
        this.quizScores = quizScores;
    }

    public double getQuizAverage() {
        return quizAverage;
    }

    public void setQuizAverage(double quizAverage) {
        this.quizAverage = quizAverage;
    }

}
