//LEAVE THESE IMPORTS, SOME TESTS ARE COMMENTED OUT
package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.Cost;
import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import ajplarson.flooringmastery.ui.ConsoleIO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ajplarson
 */
public class OrderFileDaoTest {

    public OrderFileDaoTest() {
    }

    private OrderDao oDao = new OrderFileDao();

    @Test
    public void testFindByDateApril2019() {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        List<Order> ordersThisDay = oDao.findByDate(testDate);
        assertTrue(ordersThisDay.size() > 0);
        assertTrue(ordersThisDay.get(0).getCompany().equalsIgnoreCase("parisian group"));
    }

    @Test
    public void testFindByDateNull() throws StorageException {
        LocalDate testDate = LocalDate.of(1887, Month.APRIL, 1); //no such file
        List<Order> ordersThisDay = oDao.findByDate(testDate);
        assertTrue(ordersThisDay.size() == 0);

        /*test adding a header to a non existent file
        LocalDate testDate2 = LocalDate.of(2019, Month.APRIL, 1);
        Order testOrder = dao.getOrder(10, testDate2);
        oDao.add(testOrder, testDate); */
    }

    //public boolean removeOrder(int orderNumber,LocalDate date)
    /* WORKS uncomment to run test
    @Test
    public void testRemoveOrder() throws Exception {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        //assertTrue(dao.removeOrder(1, testDate)); 
    }*/
    
    @Test
    public void testGetOrder() {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        Order testOrder = oDao.getOrder(10, testDate);
        assertTrue(testOrder.getCompany().equalsIgnoreCase("rolfson inc"));
    }

    //public void add(Order order, LocalDate date) 
    /* WORKS uncomment to run test
    @Test
    public void testAdd() throws Exception {
        Order testOrder = new Order();
        Cost testCost = new Cost();
        testCost.setGross(BigDecimal.ZERO);
        testCost.setLaborCost(BigDecimal.ZERO);
        testCost.setMaterialCost(BigDecimal.ZERO);
        testCost.setTax(BigDecimal.ZERO);
        
        State testState = new State("MN", new BigDecimal("2"));
        
        Product testProduct = new Product("micah", BigDecimal.ZERO, BigDecimal.ZERO);
        testOrder.setArea(BigDecimal.ONE);
        testOrder.setCompany("Jebediah Inc");
        testOrder.setCost(testCost);
        testOrder.setState(testState);
        testOrder.setProduct(testProduct);
        
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        
        dao.add(testOrder, testDate);
        
        assertTrue(dao.getOrder(13, testDate).getCompany().equals("Jebediah Inc"));
    } */

    /* WORKS uncomment to run test
    @Test
    public void testUpdate() throws Exception {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        Order testOrder = oDao.getOrder(10, testDate);
        testOrder.setCompany("Rollo & Sons Inc"); //fromn Rolfson Inc
        oDao.update(testOrder, testDate);
        assertTrue(oDao.getOrder(10, testDate).getCompany().equals("Rollo & Sons Inc"));
    } */
}
