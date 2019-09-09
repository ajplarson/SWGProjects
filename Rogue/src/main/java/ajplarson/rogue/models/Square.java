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
public class Square {
    private SquareContent squareContent;
    private int xcoord;
    private int ycoord;
    private int squareId;

    public Square(){
        
    }
    public Square(SquareContent squareContent, int xcoord, int ycoord,int squareId) {
        this.squareContent = squareContent;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.squareId=squareId;
    }

    public SquareContent getSquareContent() {
        return squareContent;
    }

    public void setSquareContent(SquareContent squareContent) {
        this.squareContent = squareContent;
    }

    public int getSquareId() {
        return squareId;
    }

    public void setSquareId(int squareId) {
        this.squareId = squareId;
    }
    
    


    public int getXcoord() {
        return xcoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }

    
}
