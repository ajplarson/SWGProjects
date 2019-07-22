package ajplarson.bullsandcows.data;

import ajplarson.bullsandcows.TestApplicationConfiguration;
import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Round;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author ajplarson
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class NumberDaoTest {

    @Autowired
    NumberDatabaseDao dao;

    public NumberDaoTest() {
    }

    @BeforeEach
    public void setUp() {
        List<Round> rounds = dao.getAllRounds();
        for (Round r : rounds) {
            dao.deleteById(r.getGameId());
        }
    }

    /*
     * Test of getAllGuesses method, of class NumberDao.
     */
    @Test
    public void testGetAllGuesses() {
        assertTrue(dao.getAllGames().isEmpty());
    }
//
//    /**
//     * Test of getAllRounds method, of class NumberDao.
//     */
//    @Test
//    public void testGetAllRounds() {
//    }
//
//    /**
//     * Test of getRoundsById method, of class NumberDao.
//     */
//    @Test
//    public void testGetRoundsById() {
//    }
//
//    /**
//     * Test of getAllGames method, of class NumberDao.
//     */
//    @Test
//    public void testGetAllGames() {
//    }

}
