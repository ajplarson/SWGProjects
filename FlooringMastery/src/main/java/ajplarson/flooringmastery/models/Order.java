/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.flooringmastery.models;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author ajplarson
 */
public class Order {

    private int orderNumber;
    private String company;
    private State state;
    private Product product;
    private BigDecimal area;
    private Cost cost;
    private LocalDate date;

    public Order() {

    }

    public Order(String company, State state, Product product, BigDecimal area, Cost cost) {
        this.company = company;
        this.state = state;
        this.product = product;
        this.area = area;
        this.cost = cost;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
