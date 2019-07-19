package ajplarson.flooringmastery.service;

import ajplarson.flooringmastery.data.OrderFileDao;
import ajplarson.flooringmastery.data.ProductFileDao;
import ajplarson.flooringmastery.data.StorageException;
import ajplarson.flooringmastery.data.TaxFileDao;
import ajplarson.flooringmastery.models.Cost;
import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class OrderService {

    private OrderFileDao oDao;
    private ProductFileDao pDao;
    private TaxFileDao tDao;

    public OrderService(OrderFileDao oDao, ProductFileDao pDao, TaxFileDao tDao) {
        this.oDao = oDao;
        this.pDao = pDao;
        this.tDao = tDao;
    }

    public Cost calculateCost(Order order) {
        Cost calculatedCost = new Cost();
        Product product = order.getProduct();
        State state = order.getState();
        BigDecimal materialCost = product.getMaterialCostPerSquareFoot().multiply(order.getArea());
        BigDecimal laborCost = product.getLaborCostPerSquareFoot().multiply(order.getArea());
        BigDecimal tax = (materialCost.add(laborCost)).multiply(state.getTaxRate().divide(new BigDecimal("100")));
        BigDecimal grossCost = tax.add(materialCost.add(laborCost));
        calculatedCost.setTax(tax);
        calculatedCost.setMaterialCost(materialCost);
        calculatedCost.setLaborCost(laborCost);
        calculatedCost.setGross(grossCost);
        return calculatedCost;
    }

    //BEGIN: CRUD
    public Response add(Order order, LocalDate date) {
        Response response = new Response();

        Order existing = oDao.getOrder(order.getOrderNumber(), date);

        if (existing != null) {
            response.addError("Duplicate order: " + order.getOrderNumber());
            return response;
        }
        if (response.hasError()) {
            return response;
        }
        try {
            if (order != null) {
                oDao.add(order, date);
            }
        } catch (StorageException ex) {
            response.addError(ex.getMessage());
        }
        return response;
    }

    public Result remove(Order order, LocalDate date) {
        Result result = new Result();
        Order existing = oDao.getOrder(order.getOrderNumber(), date);

        if (existing == null) {
            result.addError("That order does not exist: " + order.getOrderNumber());
            return result;
        }
        try {
            oDao.removeOrder(order.getOrderNumber(), date);
        } catch (StorageException ex) {
            result.addError(ex.getMessage());
        }
        return result;
    }

    //takes an order and updates it
    public Result edit(Order order, LocalDate date) {
        Result result = new Result();
        result = checkOrder(order, date);
        if (result.hasError()) {
            return result;
        }

        try {
            order.setCost(calculateCost(order));
            if (oDao.update(order, date)) {
                return result;
            } else {
                result.addError("Error updating");
                return result;
            }
        } catch (StorageException | NumberFormatException ex) {
            result.addError(ex.getMessage());
        }
        return result;
    }

    public List<Order> findByDate(LocalDate date) {
        List<Order> orders = oDao.findByDate(date);
        return (orders.size()) == 0 ? null : orders;
    }

    public List<Product> getProducts() {
        return pDao.findAll();
    }

    public List<State> getStates() {
        return tDao.findAll();
    }

    public State getRestOfState(String stateName) {
        return tDao.findByState(stateName);
    }

    public Product getRestOfProduct(String productName) {
        return pDao.findByMaterial(productName);
    }

    public Order getOrder(int orderNumber, LocalDate date) {
        return oDao.getOrder(orderNumber, date);
    }

    public Result checkOrderNumber(int orderNumber, LocalDate date) {
        List<Order> orders = oDao.findByDate(date);
        Result result = new Result();
        if (!(Validation.isValidOrderNumber(orders, orderNumber))) {
            result.addError("Invalid order number");
            return result;
        }
        return result;
    }

    public Result checkOrder(Order order, LocalDate date) {
        List<State> states = tDao.findAll();
        List<Product> products = pDao.findAll();

        Result result = new Result();

        if ((Validation.isState(states, order.getState())) == null) {
            result.addError(
                    String.format("State '%s' is not valid.", order.getState().getStateName())
            );
        }
        if (Validation.isProduct(products, order.getProduct()) == null) {
            result.addError(
                    String.format("Material Type '%s' is not valid.", order.getProduct().getMaterialType())
            );
        }
        if (Validation.isNullOrWhitespace(order.getCompany())) {
            result.addError("Company name is required.");
        }
        if (!(Validation.bigDecimalInRange(order.getArea()))) {
            result.addError(
                    String.format("Area '%s' is not valid.", order.getArea())
            );
        }

        if (result.hasError()) {
            return result;
        }
        order.setCost(calculateCost(order));
        result.setValue(order);
        return result;
    }

}
