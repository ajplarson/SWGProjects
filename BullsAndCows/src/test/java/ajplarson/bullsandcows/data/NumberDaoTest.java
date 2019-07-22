package ajplarson.bullsandcows.data;

import ajplarson.bullsandcows.TestApplicationConfiguration;
import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Round;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

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
            dao.deleteRoundById(r.getGameId());
        }
    }

    /*
     * Test of getAllGuesses method, of class NumberDao.
     */
    @Test
    public void testGetAllGuesses() {
        Game game = new Game(1, "1234");
        Game game2 = new Game(2, "4321");
        assertTrue(dao.getAllGames().isEmpty());
        dao.add(game2);
        dao.add(game);
        assertEquals(2, dao.getAllGames().size());
    }

    /**
     * Test of getAllRounds method, of class NumberDao.
     *  public Round(int roundNumber, int exact, int partial, Timestamp time, String guess, int gameId)
     */
    @Test
    public void testGetAllRounds() { 
        assertTrue(dao.getAllRounds().isEmpty());
        Round round = new Round (1, 1, 1, Timestamp.valueOf(LocalDateTime.now()), "1234", 1);
        dao.add(round);
        assertTrue(dao.getAllRounds().size() != 0);
    }

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
