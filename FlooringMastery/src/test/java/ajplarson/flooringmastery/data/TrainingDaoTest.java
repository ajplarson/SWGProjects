package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.Order;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ajplarson
 */
public class TrainingDaoTest {
    
    public TrainingDaoTest() {
    }

    TrainingDao oDao = new TrainingDao();
    
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
    }

    @Test
    public void testRemoveOrder() throws Exception {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        Order testOrder = oDao.getOrder(10, testDate);
        List<Order> orders = oDao.findByDate(testDate);
        int ordersSize = orders.size();
        oDao.removeOrder(testOrder.getOrderNumber(), testDate);
        assertEquals(ordersSize, orders.size()); 
    }

    @Test
    public void testGetOrder() {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        Order testOrder = oDao.getOrder(10, testDate);
        assertTrue(testOrder.getCompany().equalsIgnoreCase("rolfson inc"));
    }

    @Test
    public void testAdd() throws Exception {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        Order testOrder = oDao.getOrder(10, testDate);
        List<Order> orders = oDao.findByDate(testDate);
        int ordersSize = orders.size();
        oDao.add(testOrder, testDate);
        assertEquals(ordersSize, orders.size()); 
    }

    @Test
    public void testUpdate() throws Exception {
        LocalDate testDate = LocalDate.of(2019, Month.APRIL, 1);
        Order testOrder = oDao.getOrder(10, testDate);
        Order testOrder2 = oDao.getOrder(9, testDate);
        oDao.update(testOrder2, testDate);
        assertFalse(testOrder.getCompany().equalsIgnoreCase(testOrder2.getCompany())); 
    }
    
}
