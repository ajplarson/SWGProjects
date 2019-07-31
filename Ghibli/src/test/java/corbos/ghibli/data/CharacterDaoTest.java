package corbos.ghibli.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CharacterDaoTest {

    private final CharacterDao dao;

    @Autowired
    public CharacterDaoTest(CharacterDao dao) {
        this.dao = dao;
    }

    @Test
    public void testFindByMovieIdExists() {
        assertTrue(dao.findByMovieId(1).size() > 0);
    }

    @Test
    public void testFindByMovieIdDoesntExists() {
        assertTrue(dao.findByMovieId(1000).isEmpty());
    }

}
