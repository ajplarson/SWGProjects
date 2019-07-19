/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.flooringmastery.models;

import java.math.BigDecimal;

/**
 *
 * @author ajplarson
 */
public class State {

    private String stateName;
    private BigDecimal taxRate;

    public State() {

    }

    public State(String stateName, BigDecimal taxRate) {
        this.stateName = stateName;
        this.taxRate = taxRate;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

}
