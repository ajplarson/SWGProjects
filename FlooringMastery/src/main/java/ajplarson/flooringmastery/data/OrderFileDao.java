package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.Cost;
import ajplarson.flooringmastery.models.Order;
import ajplarson.flooringmastery.models.Product;
import ajplarson.flooringmastery.models.State;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderFileDao
        extends FileDao<Order>
        implements OrderDao {
    
    @Override
    public List<Order> findByDate(LocalDate date) {
        setDate(date);
        try {
            return read(this::mapToOrder).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }

    }

    @Override
    public boolean removeOrder(int orderNumber, LocalDate date) throws StorageException {
        List<Order> orders = findByDate(date);
        int index = 0;
        for (; index < orders.size(); index++) {
            if (orders.get(index).getOrderNumber()
                    == (orderNumber)) {
                break;
            }
        }

        if (index < orders.size()) {
            orders.remove(index);
            appendHeader();
            write(orders, this::mapToString);
            return true;
        }
        return false;
    }

    @Override
    public Order getOrder(int orderNumber, LocalDate date) {
        return findByDate(date).stream()
                .filter(o -> o.getOrderNumber() == orderNumber)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Order order, LocalDate date) throws StorageException {
        int max = findByDate(date).stream()
                .mapToInt(o -> o.getOrderNumber())
                .max()
                .orElse(0);
        //handles adding the header to empty file
        setDate(date);
        File file = new File(getPath());
        if (file.length() == 0 || (!file.exists())) {
            appendHeader();
        }
        order.setOrderNumber(max + 1);

        append(order, this::mapToString);
    }

    @Override
    public boolean update(Order order, LocalDate date) throws StorageException {
        List<Order> orders = findByDate(date);
        int index = 0;
        for (; index < orders.size(); index++) {
            if (orders.get(index).getOrderNumber()
                    == (order.getOrderNumber())) {
                break;
            }
        }

        if (index < orders.size()) {
            orders.set(index, order);
            editWrite(orders, this::mapToString);
            return true;
        }

        return false;
    }

    //follows the following format
    //0 #,1 name,2 state,3 taxrate,4 product, 5 area,
    //6 cost per sq foot, 7 labor per sq foot, 8 material cost
    //9 labor cost, 10 tax, 11 total
    private String mapToString(Order order) {
        return String.format("%s,%s,%s,%s,%s,%s,"
                + "%s,%s,%s,%s,%s,%s",
                order.getOrderNumber(),
                order.getCompany(),
                order.getState().getStateName(),
                order.getState().getTaxRate().toPlainString(),
                order.getProduct().getMaterialType(),
                order.getArea().toPlainString(),
                order.getProduct().getMaterialCostPerSquareFoot(),
                order.getProduct().getLaborCostPerSquareFoot(),
                order.getCost().getMaterialCost().toPlainString(),
                order.getCost().getLaborCost().toPlainString(),
                order.getCost().getTax().toPlainString(),
                order.getCost().getGross().toPlainString());
    }

    //public Order
    //(String company, State state, Product product, BigDecimal area, Cost cost)
    //a lot here so I get everything set up and then I go in order of token according
    //to the above list
    private Order mapToOrder(String[] tokens) {
        BigDecimal area = new BigDecimal(tokens[5]);

        //setting the state
        //State(String stateName, BigDecimal taxRate)
        State state = new State(tokens[2], new BigDecimal(tokens[3]));

        //setting the product
        //Product(String materialType, BigDecimal materialCostPerSquareFoot, BigDecimal laborCostPerSquareFoot)
        Product product = new Product(tokens[4], new BigDecimal(tokens[6]), new BigDecimal(tokens[7]));

        //setting the cost
        Cost cost = new Cost();
        cost.setMaterialCost(new BigDecimal(tokens[8]));
        cost.setLaborCost(new BigDecimal(tokens[9]));
        cost.setTax(new BigDecimal(tokens[10]));
        cost.setGross(new BigDecimal(tokens[11]));

        Order order = new Order();
        order.setOrderNumber(Integer.parseInt(tokens[0]));
        order.setCompany(tokens[1]);
        order.setArea(area);
        order.setCost(cost);
        order.setProduct(product);
        order.setState(state);

        return order;
    }
}
