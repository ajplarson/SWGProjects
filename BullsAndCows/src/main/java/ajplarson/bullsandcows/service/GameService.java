package ajplarson.bullsandcows.service;

import ajplarson.bullsandcows.data.NumberDao;
import ajplarson.bullsandcows.models.Game;
import ajplarson.bullsandcows.models.Guess;
import ajplarson.bullsandcows.models.GuessResult;
import ajplarson.bullsandcows.models.GuessStatus;
import ajplarson.bullsandcows.models.Round;
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
        for(int i = 0; i < NUM_NUMBERS; i++) {
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

        GuessResult result = new GuessResult();

        Game game = games.stream()
                .filter(g -> g.getGameId() == guess.getGuessId())
                .findFirst()
                .orElse(null);

        if (game == null) {
            return result;
        }

        // is game already won?
        if (game.getRemainingNumbers() == 0) {
            result.setStatus(GuessStatus.Win);
            return result;
        }

        // is game already lost?
        if (game.getIncorrectCount() >= MAX_GUESSES) {
            result.setStatus(GuessStatus.Loss);
            return result;
        }

        if (game.getRemainingNumbers() == 0) {
            result.setStatus(GuessStatus.Win);
        } else if (game.getIncorrectCount() >= MAX_GUESSES) {
            result.setStatus(GuessStatus.Loss);
        } else {
            result.setStatus(GuessStatus.Continue);
        }
        
        
        //loop to handle exact match assignment
        for (int i = 0; i < game.getGuesses().size(); i++) {
            if (game.getGuesses().get(i) == game.getWinningNumbers().charAt(i)) {
                
            }
        }
        
        //loop to handle partial match assignment

        result.setStatus(GuessStatus.Continue);
        return result;
    }

    public List<Game> getAllGames() {
        return numberDao.getAllGames();
    }

    public List<Round> getRoundsById(int gameId) {
        return numberDao.getRoundsById(gameId);
    }
}
