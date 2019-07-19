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
public class Product {

    private String materialType;
    private BigDecimal materialCostPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;

    public Product() {

    }

    public Product(String materialType, BigDecimal materialCostPerSquareFoot, BigDecimal laborCostPerSquareFoot) {
        this.materialType = materialType;
        this.materialCostPerSquareFoot = materialCostPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getMaterialCostPerSquareFoot() {
        return materialCostPerSquareFoot;
    }

    public void setMaterialCostPerSquareFoot(BigDecimal materialCostPerSquareFoot) {
        this.materialCostPerSquareFoot = materialCostPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

}
