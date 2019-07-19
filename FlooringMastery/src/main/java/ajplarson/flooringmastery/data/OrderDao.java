package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.Order;
import java.time.LocalDate;
import java.util.List;

public interface OrderDao {

    Order getOrder(int orderNumber, LocalDate date);

    List<Order> findByDate(LocalDate date);

    void add(Order order, LocalDate date) throws StorageException;

    boolean removeOrder(int orderNumber, LocalDate date) throws StorageException;

    boolean update(Order order, LocalDate date) throws StorageException;
}
