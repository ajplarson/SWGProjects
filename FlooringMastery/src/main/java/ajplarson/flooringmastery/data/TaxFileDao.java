package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.State;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ajplarson
 */
public class TaxFileDao
        extends FileDao<State>
        implements TaxDao {

    public TaxFileDao(String path) {
        super(path, 2, true);
    }

    @Override
    public List<State> findAll() {
        try {
            return read(this::mapToTax).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public State findByState(String stateName) {
        return findAll().stream()
                .filter(t -> t.getStateName().equals(stateName))
                .findFirst()
                .orElse(null);
    }

    private State mapToTax(String[] tokens) {
        BigDecimal taxRate = new BigDecimal(tokens[1]);
        return new State(
                tokens[0],
                taxRate);
    }

}
