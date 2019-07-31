package corbos.ghibli.data;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDao {

    private final JdbcTemplate jdbc;

    public CharacterDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public corbos.ghibli.models.Character findById(int characterId) {
        final String sql = "SELECT characterid, name FROM `character` "
                + "WHERE characterid = ?;";
        return jdbc.query(sql, new CharacterMapper(), characterId)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<corbos.ghibli.models.Character> findByMovieId(int movieId) {
        final String sql = "SELECT characterid, name FROM `character` "
                + "WHERE movieid = ?;";
        return jdbc.query(sql, new CharacterMapper(), movieId);
    }
}
