package corbos.ghibli.data;

import corbos.ghibli.models.Movie;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {

    private final JdbcTemplate jdbc;

    public MovieDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Movie> findAll() {
        return jdbc.query(
                "SELECT movieid, title, posterurl FROM movie;",
                new MovieMapper());
    }

    public Movie findById(int movieId) {

        final String sql = "SELECT movieid, title, posterurl "
                + "FROM movie "
                + "WHERE movieid = ?;";

        return jdbc.query(sql, new MovieMapper(), movieId)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public Movie findByCharacterId(int characterId) {

        final String sql = "SELECT m.movieid, m.title, m.posterurl "
                + "FROM movie m "
                + "INNER JOIN `character` c ON m.movieid = c.movieid "
                + "WHERE c.characterid = ?;";

        return jdbc.query(sql, new MovieMapper(), characterId)
                .stream()
                .findFirst()
                .orElse(null);
    }
    
    public Movie addMovie(String movieName, String posterUrl) {
        Movie movie = new Movie();
        movie.setPosterUrl(posterUrl);
        movie.setTitle(movieName);
        final String sqlInsert = ("INSERT INTO movie(title, posterurl) values (?, ?);");
        jdbc.update(sqlInsert, movieName, posterUrl);

        final String sqlGetId = ("SELECT * from movie where title = ?;");
        return jdbc.queryForObject(sqlGetId, new MovieMapper(), movieName);
    }
}
