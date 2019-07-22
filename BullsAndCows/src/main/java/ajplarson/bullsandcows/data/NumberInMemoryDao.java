package ajplarson.bullsandcows.data;

import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Guess;
import ajplarson.bullsandcows.models.Round;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Andrew
 */
@Repository
@Profile("memory")
public class NumberInMemoryDao implements NumberDao {

    private static final List<Game> games = new ArrayList<>(); //all games
    private static final List<Round> rounds = new ArrayList<>(); //all rounds
    private static final List<Guess> guesses = new ArrayList<>(); //all guesses

    @Override
    public List<Round> getAllRounds() {
        return new ArrayList<>(rounds);
    }

    @Override
    public List<Round> getRoundsById(int gameId) {
        return new ArrayList<>(
                (Collection<? extends Round>) rounds.stream()
                        .filter(g -> g.getGameId() == gameId)
                        .findFirst()
                        .orElse(null));
    }

    @Override
    public List<Guess> getAllGuesses() {
        return new ArrayList<>(guesses);
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    @Override
    public Game getGameById(int gameId) {
        return games.stream()
                .filter(g -> g.getGameId() == gameId)
                .findFirst()
                .orElse(null);
    }

}
