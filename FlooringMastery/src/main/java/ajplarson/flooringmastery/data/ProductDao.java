package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.Product;
import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    Product findByMaterial(String materialName);

}
