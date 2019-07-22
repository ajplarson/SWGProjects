package ajplarson.bullsandcows.data;

import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Guess;
import ajplarson.bullsandcows.models.Round;
import java.util.List;

/**
 * @author Andrew
 */
public interface NumberDao {

    List<Round> getAllRounds();

    List<Round> getRoundsById(int gameId);

    List<Guess> getAllGuesses();

    List<Game> getAllGames();

    Game getGameById(int gameId);
}
