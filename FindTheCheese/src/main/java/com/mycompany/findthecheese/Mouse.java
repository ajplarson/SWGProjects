/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.findthecheese;

/**
 *
 * @author ajplarson
 */
public class Mouse {
    private int x;
    private int y;
    
    public Mouse(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public void moveUp() {
      y--;   
    }
    public void moveRight() {
      x++; 
    }
    public void moveDown() {
      y++;  
    }
    public void moveLeft() {
      x--;  
    }
    
    public char getMouseSymbol() {
        return 'M';
    }
}
