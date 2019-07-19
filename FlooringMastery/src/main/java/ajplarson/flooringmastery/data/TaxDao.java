package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.State;
import java.util.List;

/**
 * @author ajplarson
 */
public interface TaxDao {

    List<State> findAll();

    State findByState(String stateName);

}
