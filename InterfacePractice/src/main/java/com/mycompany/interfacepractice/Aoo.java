/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfacepractice;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ajplarson
 */
public class Aoo {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        int i = 0;
        System.out.println("List size before adding strings: " + stringList.size());
        stringList.add("my first string" + "second string");
        System.out.println("Now it is " + stringList.size() + " long.");
        stringList.remove(0);
        System.out.println(stringList);
        while (i < 10) {
            stringList.add("we got a new number " + i);
            i++;
        }
        Iterator<String> iter = stringList.iterator();
        while (iter.hasNext()) {
            String current = iter.next();
            System.out.println(current);
        }
        
    }
}
