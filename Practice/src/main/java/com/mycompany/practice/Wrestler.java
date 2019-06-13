/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practice;


/**
 *
 * @author ajplarson
 */
public class Wrestler {
    
    private String name;
    private int stamina = 100;
    
    public Wrestler(String name) {
        this.name = name;
    }
    
    public boolean isDefeated() {
        return stamina <= 0;
    }
    
    public void decreaseStamina(int amount) {
        stamina = stamina - amount;
    }

    public int getStamina() {
        return stamina;
    }
    
    public int attack() {
      return Game.RAND.nextInt(11) + 10;
    }
    
}
