package corbos.ghibli.data;

import corbos.ghibli.models.Scene;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SceneDao {

    private final JdbcTemplate jdbc;

    public SceneDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Scene> findByMovieId(int movieId) {
        final String sql = "SELECT sceneid, name FROM scene "
                + "WHERE movieid = ?;";
        return jdbc.query(sql, new SceneMapper(), movieId);
    }

    public List<Scene> findByCharacterId(int characterId) {

        final String sql = "SELECT s.sceneid, s.name "
                + "FROM scene s "
                + "INNER JOIN characterscene cs ON s.sceneid = cs.sceneid "
                + "WHERE cs.characterid = ?;";

        return jdbc.query(sql, new SceneMapper(), characterId);
    }

}
