package ajplarson.flooringmastery.data;

import ajplarson.flooringmastery.models.State;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrew
 */
public class TaxFileDaoTest {
    private final TaxFileDao tDao = new TaxFileDao("files/test_states.txt");
    private final List<State> states = tDao.findAll();
    
    public TaxFileDaoTest() {
    }

    /**
     * Test of findAll method, of class TaxFileDao.
     */
    @Test
    public void testFindAll() {
        assertTrue(states.size() > 0);
        assertEquals(9, states.size());
    }

    /**
     * Test of findByState method, of class TaxFileDao.
     */
    @Test
    public void testFindByState() {
        State userState = new State("MN", new BigDecimal("5.00"));
        State minnesota = tDao.findByState("MN");
        assertTrue(minnesota.getStateName().equalsIgnoreCase(userState.getStateName()));
        assertTrue(minnesota.getTaxRate().equals(userState.getTaxRate()));
    }
    
}
