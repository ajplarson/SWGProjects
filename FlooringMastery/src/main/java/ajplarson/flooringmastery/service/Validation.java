package ajplarson.flooringmastery.service;

import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Validation {

    public static State isState(List<State> states, State userState) {
        if (userState != null) {
            for (State state : states) {
                if (state.getStateName().equalsIgnoreCase(userState.getStateName())) {
                    userState.setTaxRate(state.getTaxRate());
                    return userState;
                }
            }
        }
        return null;
    }

    public static Product isProduct(List<Product> products, Product product) {
        if (product != null) {
            for (Product currentProduct : products) {
                if (product.getMaterialType().equalsIgnoreCase(currentProduct.getMaterialType())) {
                    product.setLaborCostPerSquareFoot(currentProduct.getLaborCostPerSquareFoot());
                    product.setMaterialCostPerSquareFoot(currentProduct.getMaterialCostPerSquareFoot());
                    return product;
                }
            }
        }
        return null;
    }

    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public static boolean isNullOrWhitespace(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean bigDecimalInRange(BigDecimal value) {
        return value.compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean isValidOrderNumber(List<Order> orders, int orderNumber) {
        List<Integer> orderNumbers = new ArrayList<>();
        int min = 0;
        int max = 0;
        for (int i = 0; i < orders.size(); i++) {
            orderNumbers.add(orders.get(i).getOrderNumber());
        }
        Collections.sort(orderNumbers); //sometimes the min is not zero

        for (int j = 0; j < orderNumbers.size(); j++) {
            min = orderNumbers.get(0);
            if (orderNumbers.get(j) > max) {
                max = orderNumbers.get(j);
            }
        }
        return (orderNumber >= min && orderNumber <= max);
    }
}
