/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trycollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) {

        HashMap<String, Person> personMap = new HashMap<>();
        for(Person p: allPeople()) {
            personMap.put(p.getEmailAddress(), p);
        }
    }

    private static void print(Person p) {
        System.out.printf("%s %s: %s", p.getFirstName(),
                p.getLastName(), p.getEmailAddress());
    }

    private static List<Person> allPeople() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Oates", "Deely", "odeely@joomala.org"));
        people.add(new Person("Dfstes", "Joney", "oly@joaola.org"));
        people.add(new Person("asddOates", "Deefeefy", "o@mala.org"));
        people.add(new Person("OatJebbes", "sDfely", "ode2d@joomala.org"));
        return people;
    }

}
