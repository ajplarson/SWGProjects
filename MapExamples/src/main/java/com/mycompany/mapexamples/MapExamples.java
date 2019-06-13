/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapexamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ajplarson
 */
public class MapExamples {
    public static void main(String[] args) {
        Map<String, Integer> populations = new HashMap<>();
        
        populations.put("USA", 313000000);
        populations.put("Canada", 34000000);
        populations.put("UK", 63000000);
        populations.put("Japan", 127000000);
        
        System.out.println("Map size is " + populations.size());
        
        Integer usaPopulation = populations.get("USA");
        System.out.println("USA population is " + usaPopulation);
        
        Collection<Integer> values = populations.values();
        
        for(Integer k: values) {
            System.out.println(k);
        }
        
        
    }
   
}
