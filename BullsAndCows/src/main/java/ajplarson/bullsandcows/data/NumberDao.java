package ajplarson.bullsandcows.data;

import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Guess;
import ajplarson.bullsandcows.models.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author ajplarson
 */
@Repository
public class NumberDao {

    private final JdbcTemplate jdbcTemplate;

    public NumberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Guess> getAllGuesses() {
        final String sql = "select * from game g inner join round r on r.gameid = g.gameid inner join guess gu on r.guessid = gu.guessid;";
        return jdbcTemplate.query(sql, new GuessMapper());
    }

    public List<Round> getAllRounds() {
        final String sql = "select * from game g inner join round r on r.gameid = g.gameid inner join guess gu on r.guessid = gu.guessid;";
        return jdbcTemplate.query(sql, new RoundMapper());
    }

    public List<Round> getRoundsById(int gameId) {
        final String sql = "select * \n"
                + "\n"
                + "from game g \n"
                + "inner join round r on r.gameid = g.gameid \n"
                + "inner join guess gu on r.guessid = gu.guessid\n"
                + "group by r.roundid\n"
                + "having r.gameid = ?\n"
                + "order by r.time;";

        return jdbcTemplate.query(sql, new RoundMapper(), gameId);
    }

    public List<Game> getAllGames() {
        final String sql = "SELECT * from game;";
        return jdbcTemplate.query(sql, new GameMapper());

    }

    private static final class GuessMapper implements RowMapper<Guess> {

        @Override
        public Guess mapRow(ResultSet rs, int index) throws SQLException {
            Guess guess = new Guess();
            guess.setGuessId(Integer.parseInt(rs.getString("guessid")));
            guess.setGuessAsString(rs.getString("numbers"));
            return guess;
        }
    }

    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameId(Integer.parseInt(rs.getString("gameid")));
            game.setWinningNumbers(rs.getString("winningnumbers"));
            game.setNumberOfRounds(Integer.parseInt(rs.getString("numberofrounds")));
            return game;
        }
    }

    private static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            Guess guess = new Guess();
            guess.setGuessAsString(rs.getString("numbers"));
            guess.setGuessId(Integer.parseInt(rs.getString("guessid")));
            round.setRoundNumber(Integer.parseInt(rs.getString("roundid")));
            round.setExact(Integer.parseInt(rs.getString("exact")));
            round.setPartial(Integer.parseInt(rs.getString("partial")));
            round.setTime(rs.getTimestamp("time"));
            round.setGuess(guess);
            round.setGameId(Integer.parseInt(rs.getString("gameid")));
            return round;
        }
    }
}
