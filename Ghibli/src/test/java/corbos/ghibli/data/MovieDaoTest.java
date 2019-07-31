package corbos.ghibli.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MovieDaoTest {

    private final MovieDao dao;

    @Autowired
    public MovieDaoTest(MovieDao dao) {
        this.dao = dao;
    }

    @Test
    public void testFindAll() {
        assertTrue(dao.findAll().size() > 0);
    }

    @Test
    public void testFindByIdExists() {
        assertNotNull(dao.findById(1));
    }

    @Test
    public void testFindByIdDoesntExists() {
        assertNull(dao.findById(1000));
    }

}
