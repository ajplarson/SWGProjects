/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calendar;

/**
 *
 * @author ajplarson
 */
public class main {
    public static void main(String[] args) {
        for (int month = 1; month < 13; month++) {
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    for (int dayThirtyOne = 1; dayThirtyOne <= 31; dayThirtyOne++) {
                        System.out.println("Today's date is: " + dayThirtyOne + "/" + month + "/" + "2019");
                    }
                 }
                else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    for (int dayThirty = 1; dayThirty <= 30; dayThirty++) {
                        System.out.println("Today's date is: " + dayThirty + "/" + month + "/" + "2019");
                    }
                }
                else {
                    for (int dayTwentyEight = 1; dayTwentyEight <= 28; dayTwentyEight++) {
                        System.out.println("Today's date is: " + dayTwentyEight + "/" + month + "/" + "2019");
                    }
                }                      
        }
        System.out.println("The Calendar for 2019 has finished.");    
    }
       
}
