package corbos.ghibli.data;

import corbos.ghibli.models.Movie;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MovieMapper implements RowMapper<Movie> {
    
    @Override
    public Movie mapRow(ResultSet rs, int i) throws SQLException {
        Movie result = new Movie();
        result.setMovieId(rs.getInt("movieid"));
        result.setTitle(rs.getString("title"));
        result.setPosterUrl(rs.getString("posterurl"));
        return result;
    }
    
}
