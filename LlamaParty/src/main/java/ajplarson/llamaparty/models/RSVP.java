/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.llamaparty.models;

/**
 *
 * @author ajplarson
 */
public class RSVP {
    private boolean isGoing;
    private String name;
    private Integer numberOfLlamas;

    public boolean isIsGoing() {
        return isGoing;
    }

    public void setIsGoing(boolean isGoing) {
        this.isGoing = isGoing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfLlamas() {
        return numberOfLlamas;
    }

    public void setNumberOfLlamas(Integer numberOfLlamas) {
        this.numberOfLlamas = numberOfLlamas;
    }
    
    
}
