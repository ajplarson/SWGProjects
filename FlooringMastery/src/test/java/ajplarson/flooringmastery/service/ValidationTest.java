/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.flooringmastery.service;

import ajplarson.flooringmastery.data.OrderFileDao;
import ajplarson.flooringmastery.data.ProductFileDao;
import ajplarson.flooringmastery.data.TaxFileDao;
import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Andrew
 */
public class ValidationTest {

    private final TaxFileDao tDao = new TaxFileDao("files/test_states.txt");
    private final ProductFileDao pDao = new ProductFileDao("files/test_products.txt");
    private final List<State> states = tDao.findAll();
    private final List<Product> products = pDao.findAll();
    private OrderFileDao oDao = new OrderFileDao();

    public ValidationTest() {

    }

    /**
     * Test of isState method, of class Validation. expect null if not a valid
     * state, else the state
     */
    @Test
    public void testIsStateNull() {
        State userState = null;
        assertNull(Validation.isState(states, userState));
    }

    @Test
    public void testIsStateCanada() {
        State userState = new State("Canada", new BigDecimal("4.5"));
        assertNull(Validation.isState(states, userState));
    }

    @Test
    public void testIsStateMN() {
        State userState = new State("MN", new BigDecimal("5.00"));
        assertTrue(tDao.findByState("MN").getStateName().equals(Validation.isState(states, userState).getStateName()));
        assertTrue(tDao.findByState("MN").getTaxRate().equals(Validation.isState(states, userState).getTaxRate()));
    }

    /**
     * Test of isProduct method, of class Validation. expect null if not a valid
     * product, else the product
     */
    @Test
    public void testIsProductNull() {
        Product product = null;
        assertNull(Validation.isProduct(products, product));
    }

    @Test
    public void testIsProductJello() {
        Product product = new Product();
        product.setMaterialType("Jello");
        product.setMaterialCostPerSquareFoot(BigDecimal.ZERO);
        product.setLaborCostPerSquareFoot(BigDecimal.ZERO);
        assertNull(Validation.isProduct(products, product));
    }

    //Slate,3.50,3.75
    @Test
    public void testIsProductSlate() {
        Product product = new Product();
        product.setMaterialType("Slate");
        product.setMaterialCostPerSquareFoot(new BigDecimal("3.50"));
        product.setLaborCostPerSquareFoot(new BigDecimal("3.75"));
        assertNotNull(Validation.isProduct(products, product));
        assertTrue(pDao.findByMaterial("Slate").getMaterialType().equals(product.getMaterialType()));
        assertTrue(pDao.findByMaterial("Slate").getMaterialCostPerSquareFoot().equals(product.getMaterialCostPerSquareFoot()));
        assertTrue(pDao.findByMaterial("Slate").getLaborCostPerSquareFoot().equals(product.getLaborCostPerSquareFoot()));

    }

    /**
     * Test of inRange method, of class Validation.
     */
    @Test
    public void testInRangeFalse() {
        int value = 11;
        int value2 = 86;
        int value3 = -1;
        int min = 0;
        int max = 10;
        assertFalse(Validation.inRange(value, min, max));
        assertFalse(Validation.inRange(value2, min, max));
        assertFalse(Validation.inRange(value3, min, max));
    }

    @Test
    public void testInRangeTrue() {
        int value = 10;
        int value2 = 8;
        int value3 = 0;
        int min = 0;
        int max = 10;
        assertTrue(Validation.inRange(value, min, max));
        assertTrue(Validation.inRange(value2, min, max));
        assertTrue(Validation.inRange(value3, min, max));
    }

    /**
     * Test of isNullOrWhitespace method, of class Validation.
     */
    @Test
    public void testIsNullorWhitespace() {
        assertTrue(Validation.isNullOrWhitespace(null));
        assertTrue(Validation.isNullOrWhitespace("   "));
    }

    /**
     * Test of bigDecimalInRange method, of class Validation. makes sure value
     * inputted is greater than zero
     */
    @Test
    public void testBigDecimalInRangeFalse() {
        BigDecimal value = new BigDecimal("-1");
        assertFalse(Validation.bigDecimalInRange(value));
    }

    @Test
    public void testBigDecimalInRangeTrue() {
        BigDecimal value = new BigDecimal("0.1");
        BigDecimal value2 = new BigDecimal("0");
        assertTrue(Validation.bigDecimalInRange(value));
        assertTrue(Validation.bigDecimalInRange(value2));
    }

    /**
     * Test of isValidOrderNumber method, of class Validation.
     */
    @Test
    public void testIsValidOrderNumber() {
        String str = "1111-11-11"; //orders from 745 to 763
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        List<Order> orders = oDao.findByDate(dateTime);
        int orderNumber = 0;
        int orderNumber2 = 5421;
        int orderNumber3 = 744;
        assertFalse(Validation.isValidOrderNumber(orders, orderNumber));
        assertFalse(Validation.isValidOrderNumber(orders, orderNumber2));
        assertFalse(Validation.isValidOrderNumber(orders, orderNumber3));
    }
}
