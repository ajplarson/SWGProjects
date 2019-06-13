/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        HashMap<String, Capital> statesMap = new HashMap<>();
        ArrayList<State> statesList = new ArrayList<>();
        
        Capital stpaul = new Capital("St. Paul", 100000);
        State minnesota = new State("MN", stpaul);
        statesList.add(minnesota);
        
        Capital madison = new Capital ("Madison", 20010);
        State wisconsin = new State("WI", madison);
        statesList.add(wisconsin);
        
        Capital newyorkcity = new Capital("New York City", 1000239);
        State newyork = new State("NY", newyorkcity);
        statesList.add(newyork);
        

        for(State p: statesList) {
        statesMap.put(p.getStateAbbreviation(), p.getStateCapital());
        }
        for(String key: statesMap.keySet()) {
            System.out.println("State: " + key +" has the capital " + statesMap.get(key).getName() + " and a population " + statesMap.get(key).getPopulation());
        }

    }
}
