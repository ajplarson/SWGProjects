/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.service.Validation;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andrew
 */
public class ProductFileDaoTest {
    private final ProductFileDao pDao = new ProductFileDao("files/test_products.txt");
    private final List<Product> products = pDao.findAll();
    public ProductFileDaoTest() {
    }

    /**
     * Test of findAll method, of class ProductFileDao.
     */
    @Test
    public void testFindAll() {
        assertTrue(products.size() > 0);
        assertEquals(15, products.size());
    }

    /**
     * Test of findByMaterial method, of class ProductFileDao.
     */
    @Test
    public void testFindByMaterial() {
        Product testProduct = pDao.findByMaterial("Shag Carpet");
        Product product = new Product();
        product.setMaterialType("Shag Carpet");
        product.setMaterialCostPerSquareFoot(new BigDecimal("2.00"));
        product.setLaborCostPerSquareFoot(new BigDecimal("4.25"));
        assertTrue(testProduct.getMaterialType().equals(product.getMaterialType()));
        assertTrue(testProduct.getMaterialCostPerSquareFoot().equals(product.getMaterialCostPerSquareFoot()));
        assertTrue(testProduct.getLaborCostPerSquareFoot().equals(product.getLaborCostPerSquareFoot()));
        
    }
    
}
