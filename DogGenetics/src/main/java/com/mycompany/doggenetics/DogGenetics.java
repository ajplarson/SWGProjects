/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doggenetics;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class DogGenetics {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfDogTypes = 5;
        String[] dogTypes = {"Poodle", "Golden Retriever", "Siberian Husky", "Great Dane", "German Sheperd", "Chihuahua",
            "Golden Doodle", "Pitbull", "American Bulldog", "French Bulldog", "Bull Mastiff", "Tibetan Mastiff", "Samoyed",
            "Chocolate Labrador", "White Labrador", "Irish Setter"};
        shuffleStringArray(dogTypes);
        int[] dogPercentages = (generatePercentages(numberOfDogTypes));

        System.out.println("After investing billions of dollars in research, we have finally perfected our patent-pending instant dog genetics reader.");
        System.out.println("To begin, simply type in your dog's name.");
        String dogName = sc.nextLine();
        System.out.println("\n" + dogName + " is:");

        for (int i = 0; i < numberOfDogTypes; i++) {
            System.out.println(dogPercentages[i] + "% " + dogTypes[i]);
        }
        System.out.println("\nWOW! That's quite the dog");
    }

    //generates a specified amount of percentages that all add up to 100
    public static int[] generatePercentages(int howMany) {
        double[] percentages = new double[howMany];
        int[] outputPercentages = new int[howMany];
        double totalPercentages = 0;
        Random r = new Random();
        //loop to assign random values
        for (int i = 0; i < howMany; i++) {
            percentages[i] = r.nextInt(100);
            totalPercentages += percentages[i];
        }
        //loop to make total = 100
        for (int i = 0; i < howMany; i++) {
            percentages[i] = 100 * (percentages[i] / totalPercentages);
            outputPercentages[i] = (int) Math.round(percentages[i]);
        }
        return outputPercentages;
    }

    //Fisher-Yates Shuffling
    //Source: https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    public static void shuffleStringArray(String[] array) {
        Random r = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int newIndex = r.nextInt(i + 1); //to avoid the 0 from random
            String anElement = array[newIndex]; //takes a random element
            array[newIndex] = array[i]; //takes the current element and moves it to a random spot in the array
            array[i] = anElement; //assigns the random element to the current element in the loop
        }
    }

}
