package ajplarson.bullsandcows.service;

import ajplarson.bullsandcows.data.NumberDao;
import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Guess;
import ajplarson.bullsandcows.models.GuessResult;
import ajplarson.bullsandcows.models.GuessStatus;
import ajplarson.bullsandcows.models.Round;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private static List<Game> games = new ArrayList<>();

    private static final int MAX_GUESSES = 8;
    private static final int NUM_NUMBERS = 4;
    private static final Random rand = new Random();

    private final NumberDao numberDao;

    public GameService(NumberDao numberDao) {
        this.numberDao = numberDao;
    }

    public Game start() {
        int nextId = games.stream()
                .mapToInt(g -> g.getGameId())
                .max()
                .orElse(0) + 1;
        Game g = new Game();
        g.setWinningNumbers(makeWinningNumbers());
        g.setGameId(nextId);
        games.add(g);
        return g;
    }

    //concatenating to a blank string because .toString() has bad format
    public String makeWinningNumbers() {
        Set<Integer> nums = new HashSet<>();
        String output = "";
        while (nums.size() < NUM_NUMBERS) {
            Integer toAdd = rand.nextInt(10);
            nums.add(toAdd);
        }
        List<Integer> list = new ArrayList<>(nums);
        Collections.shuffle(list);
        for (int i = 0; i < NUM_NUMBERS; i++) {
            output += list.get(i);
        }
        return output;
    }

    public Game findById(int gameId) {
        return games.stream()
                .filter(g -> g.getGameId() == gameId)
                .findFirst()
                .orElse(null);
    }

    public GuessResult makeGuess(Guess guess) {
        Round round = new Round();
        GuessResult result = new GuessResult();
        List<Round> rounds = new ArrayList<>();
        int exact = 0;
        int partial = 0;
        int nextRoundNumber = 0;

        round.setGuess(guess);
        round.setTime(Timestamp.valueOf(LocalDateTime.now()));

        Game game = games.stream()
                .filter(g -> g.getGameId() == guess.getGameId())
                .findFirst()
                .orElse(null);
        round.setGameId(game.getGameId());

        //game is null
        if (game == null) {
            result.setStatus(GuessStatus.Shame);
            return result;
        }

        //round number
        if (game.getRounds() != null) {
            rounds = game.getRounds();
            nextRoundNumber = game.getRounds().stream()
                    .mapToInt(g -> g.getRoundNumber())
                    .max()
                    .orElse(0) + 1;
        } else {
            nextRoundNumber = 1;
        }
        round.setRoundNumber(nextRoundNumber);

        //rounds left
        result.setGuessesRemaining(MAX_GUESSES - nextRoundNumber);
        if (game.getNumberOfRounds() >= MAX_GUESSES) {
            result.setStatus(GuessStatus.Loss);
            return result;
        }

        //loop to handle exact match assignment
        for (int i = 0; i < guess.getGuessAsString().length(); i++) {
            if (guess.getGuessAsString().charAt(i) == game.getWinningNumbers().charAt(i)) {
                exact++;
            }
        }

        //loop to handle partial match assignment
        for (int i = 0; i < guess.getGuessAsString().length(); i++) {
            for (int j = 0; j < game.getWinningNumbers().length(); j++) {
                if ((guess.getGuessAsString().charAt(i) == game.getWinningNumbers().charAt(j)) && (i != j)) {
                    partial++;
                }
            }
        }

        round.setPartial(partial);
        round.setExact(exact);
        result.setPartialGuess(partial);
        result.setExactGuess(exact);
        rounds.add(round);
        game.setRounds(rounds);
        game.setNumberOfRounds(rounds.size());

        if (exact == 4) {
            result.setStatus(GuessStatus.Win);
        } else if (game.getNumberOfRounds() >= MAX_GUESSES) {
            result.setStatus(GuessStatus.Loss);
        } else {
            result.setStatus(GuessStatus.Continue);
        }
        return result;
    }

    public List<Game> getAllGames() {
        return games;
    }

    public List<Round> getRoundsById(int gameId) {
        return numberDao.getRoundsById(gameId);
    }
}
