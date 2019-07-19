package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFileDao
        extends FileDao<Product>
        implements ProductDao {

    public ProductFileDao(String path) {
        super(path, 3, true);
    }

    @Override
    public List<Product> findAll() {
        try {
            return read(this::mapToProduct).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Product findByMaterial(String materialName) {
        return findAll().stream()
                .filter(m -> m.getMaterialType().equals(materialName))
                .findFirst()
                .orElse(null);
    }

    private Product mapToProduct(String[] tokens) {
        BigDecimal materialCostPerSquareFoot = new BigDecimal(tokens[1]);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(tokens[2]);
        return new Product(
                tokens[0],
                materialCostPerSquareFoot,
                laborCostPerSquareFoot);
    }
}
