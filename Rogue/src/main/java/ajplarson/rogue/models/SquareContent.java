/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.rogue.models;

/**
 *
 * @author ajplarson
 */
public class SquareContent {
    boolean exists;
    int squareId;
    public SquareContent(){
        
    }
    public SquareContent(int squareId){
        this.squareId = squareId;
    }
    public SquareContent(boolean exists, int squareId) {
        this.exists = exists;
        this.squareId = squareId;
    }
    
    public int getSquareId() {
        return squareId;
    }

    public void setSquareId(int squareId) {
        this.squareId = squareId;
    }
    
    
    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
    
}
