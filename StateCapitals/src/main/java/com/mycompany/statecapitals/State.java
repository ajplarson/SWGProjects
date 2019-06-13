/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals;

/**
 *
 * @author ajplarson
 */
public class State {
    private String stateAbbreviation;
    private Capital stateCapital;

    public State(String stateAbbreviation, Capital stateCapital) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateCapital = stateCapital;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public Capital getStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(Capital stateCapital) {
        this.stateCapital = stateCapital;
    }

    
    
}
