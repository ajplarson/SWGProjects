package ajplarson.bullsandcows.data;

import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Guess;
import ajplarson.bullsandcows.models.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author ajplarson
 */
@Repository
@Profile("database")
public class NumberDatabaseDao implements NumberDao {

    private final JdbcTemplate jdbcTemplate;

    public NumberDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Guess> getAllGuesses() {
        final String sql = "select * from game g inner join round r on r.gameid = g.gameid inner join guess gu on r.guessid = gu.guessid;";
        return jdbcTemplate.query(sql, new GuessMapper());
    }

    @Override
    public List<Round> getAllRounds() {
        final String sql = "select * \n"
                + "from round r \n"
                + "inner join game g on r.gameid = g.gameid\n"
                + "group by r.roundid\n"
                + "order by g.gameid;";
        return jdbcTemplate.query(sql, new RoundMapper());
    }

    @Override
    public List<Round> getRoundsById(int gameId) {
        final String sql = "select * \n"
                + "\n"
                + "from game g \n"
                + "inner join round r on r.gameid = g.gameid \n"
                + "inner join guess gu on r.guessid = gu.guessid\n"
                + "group by r.roundid\n"
                + "having r.gameid = ?\n"
                + "order by r.roundid;";

        return jdbcTemplate.query(sql, new RoundMapper(), gameId);
    }

    @Override
    public Game getGameById(int gameId) {

        final String sql = "select * \n"
                + "from game g \n"
                + "inner join round r on r.gameid = g.gameid \n"
                + "inner join guess gu on r.guessid = gu.guessid\n"
                + "group by g.gameid\n"
                + "having g.gameid = ?;";

        return jdbcTemplate.queryForObject(sql, new GameMapper(), gameId);
    }

    @Override
    public List<Game> getAllGames() {
        final String sql = "select * \n"
                + "from game g \n"
                + "inner join round r on r.gameid = g.gameid \n"
                + "inner join guess gu on r.guessid = gu.guessid\n"
                + "group by g.gameid\n"
                + "order by g.gameid ASC;";
        return jdbcTemplate.query(sql, new GameMapper());

    }

    private static final class GuessMapper implements RowMapper<Guess> {

        @Override
        public Guess mapRow(ResultSet rs, int index) throws SQLException {
            Guess guess = new Guess();
            guess.setGameId(Integer.parseInt(rs.getString("guessid")));
            guess.setGuessAsString(rs.getString("numbers"));
            return guess;
        }
    }

    private static final class GameMapper implements RowMapper<Game> {

        //Round(int roundNumber, int exact, int partial, Timestamp time, Guess guess, int gameId)
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setNumberOfRounds(Integer.parseInt(rs.getString("numberofrounds")));
            int numberOfRounds = game.getNumberOfRounds();
            List<Round> rounds = new ArrayList<>();
            for (int i = 1; i <= numberOfRounds; i++) { //this should be round id
                rounds.add(new Round(Integer.parseInt(rs.getString("roundid")), //roundnumber
                        (Integer.parseInt(rs.getString("exact"))), //exact
                        (Integer.parseInt(rs.getString("partial"))), //partial
                        (rs.getTimestamp("time")), //time 
                        (new Guess(
                                (Integer.parseInt(rs.getString("guessid"))),
                                (rs.getString("numbers")))), //guess
                        (Integer.parseInt(rs.getString("gameid"))))); //gameid
            }
            game.setRounds(rounds);
            game.setGameId(Integer.parseInt(rs.getString("gameid")));
            game.setWinningNumbers(rs.getString("winningnumbers"));
            return game;
        }
    }

    private static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            Guess guess = new Guess();
            guess.setGuessAsString(rs.getString("numbers"));
            guess.setGameId(Integer.parseInt(rs.getString("guessid")));
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
