package ajplarson.flooringmastery.service;

import ajplarson.flooringmastery.data.OrderFileDao;
import ajplarson.flooringmastery.data.ProductFileDao;
import ajplarson.flooringmastery.data.StorageException;
import ajplarson.flooringmastery.data.TaxFileDao;
import ajplarson.flooringmastery.models.Cost;
import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import ajplarson.flooringmastery.ui.ConsoleIO;
import ajplarson.flooringmastery.ui.View;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Andrew
 */
public class OrderServiceTest {

    private final TaxFileDao tDao = new TaxFileDao("files/test_states.txt");
    private final ProductFileDao pDao = new ProductFileDao("files/test_products.txt");
    private final List<State> states = tDao.findAll();
    private final List<Product> products = pDao.findAll();
    private OrderFileDao oDao = new OrderFileDao();
    private OrderService service = new OrderService(oDao, pDao, tDao);
    private ConsoleIO io = new ConsoleIO();
    private View view = new View(io);

    public OrderServiceTest() {
    }

    @BeforeEach
    public void setup() throws Exception {
        LocalDate testDate = LocalDate.of(1010, Month.OCTOBER, 10);
        List<Order> orders = oDao.findByDate(testDate);
        //reset one of the test files to a known good state
        for (Order order : orders) {
            oDao.removeOrder(order.getOrderNumber(), testDate);
         
        }
    }

    /**
     * Test of calculateCost method, of class OrderService.
     */
    @Test
    public void testCalculateCost() {
        LocalDate testDate = LocalDate.of(1111, Month.NOVEMBER, 11);
        Order order = oDao.getOrder(763, testDate);
        assertTrue(order.getCompany().equalsIgnoreCase("cormier-hayes"));
        Cost cost = service.calculateCost(order);
        //these 4 test calculating the cost
        //IL tax rate 2.5 % Linoleum is material, 1975 sq ft
        //costs should be the following
        //material: 3456.25 labor: 7900 tax: 283.91 gross: 11640.15625
        assertEquals(new BigDecimal("3456.25").doubleValue(), cost.getMaterialCost().doubleValue(), BigDecimal.ONE.doubleValue());
        assertEquals(new BigDecimal("7900").doubleValue(), cost.getLaborCost().doubleValue(), BigDecimal.ONE.doubleValue());
        assertEquals(new BigDecimal("283.91").doubleValue(), cost.getTax().doubleValue(), BigDecimal.ONE.doubleValue());
        assertEquals(new BigDecimal("11640.16").doubleValue(), cost.getGross().doubleValue(), BigDecimal.ONE.doubleValue());
    }

    /**
     * Test of add method, of class OrderService.
     */
    @Test
    public void testAdd() {
        LocalDate testDate = LocalDate.of(1010, Month.OCTOBER, 10);
        Order order = new Order();
        order.setArea(BigDecimal.ONE);
        order.setCompany("Test Company Two");
        order.setProduct(pDao.findByMaterial("Slate"));
        order.setState(tDao.findByState("MN"));
        order.setCost(service.calculateCost(order)); //I do this in the controller so I have to manually do it here
        service.add(order, testDate);

        Order addedOrder = service.getOrder(1, testDate);
        assertTrue(addedOrder.getArea().equals(order.getArea()));
        assertTrue(addedOrder.getCompany().equals("Test Company Two"));
        assertTrue(addedOrder.getProduct().getMaterialType().equalsIgnoreCase("slate"));
        assertTrue(addedOrder.getState().getStateName().equalsIgnoreCase("mn"));

    }

    /**
     * Test of remove method, of class OrderService.
     */
    @Test
    public void testRemove() throws StorageException {
        LocalDate testDate = LocalDate.of(1010, Month.OCTOBER, 10);
        Order testOrder = new Order();
        testOrder.setArea(BigDecimal.ONE);
        testOrder.setCompany("Test");
        testOrder.setProduct(pDao.findByMaterial("Slate"));
        testOrder.setState(tDao.findByState("MN"));
        testOrder.setCost(service.calculateCost(testOrder));
        service.add(testOrder, testDate);//we just tested add so it works
        List<Order> orders = oDao.findByDate(testDate);
        assertTrue(orders.size() == 1);
        service.remove(testOrder, testDate);
        orders = oDao.findByDate(testDate);
        assertTrue(orders.size() == 0);
    }

    /**
     * Test of checkOrder method, of class OrderService.
     */
    @Test
    public void testCheckOrderFalseState() {
        Result result = new Result();
        Order order = new Order();
        LocalDate testDate = LocalDate.of(1111, Month.NOVEMBER, 11);
        order.setArea(BigDecimal.ONE);
        order.setCompany("Test Company");
        order.setProduct(pDao.findByMaterial("Slate"));
        order.setDate(testDate);
        State state = new State("CA", BigDecimal.ONE);
        order.setState(state);
        result = service.checkOrder(order, testDate);
        assertTrue(result.hasError());
    }

    @Test
    public void testCheckOrderFalseProduct() {
        Result result = new Result();
        Order order = new Order();
        LocalDate testDate = LocalDate.of(1111, Month.NOVEMBER, 11);
        order.setArea(BigDecimal.ONE);
        order.setCompany("Test Company");
        Product product = new Product("Flubber", BigDecimal.ONE, BigDecimal.ONE);
        order.setProduct(product);
        order.setDate(testDate);
        order.setState(tDao.findByState("MN"));
        result = service.checkOrder(order, testDate);
        assertTrue(result.hasError());
    }

    @Test
    public void testCheckOrderTrue() {
        Result result = new Result();
        Order order = new Order();
        LocalDate testDate = LocalDate.of(1111, Month.NOVEMBER, 11);
        order.setArea(BigDecimal.ONE);
        order.setCompany("Test Company");
        order.setProduct(pDao.findByMaterial("Slate"));
        order.setDate(testDate);
        order.setState(tDao.findByState("MN"));
        result = service.checkOrder(order, testDate);
        assertFalse(result.hasError());
    }

}
