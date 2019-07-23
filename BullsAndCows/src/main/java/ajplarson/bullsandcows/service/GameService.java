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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private static final int NUM_NUMBERS = 4;
    private static final Random rand = new Random();

    private final NumberDao numberDao;

    @Autowired
    public GameService(NumberDao numberDao) {
        this.numberDao = numberDao;
    }

    public Game start() {
        //dont set ids let the database do work for you. dont have specific local lists for games use the database
        Game g = new Game();
        g.setWinningNumbers(makeWinningNumbers());
        numberDao.addGame(g);
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
        List<Game> games = numberDao.getAllGames();
        return games.stream()
                .filter(g -> g.getGameId() == gameId)
                .findFirst()
                .orElse(null);
    }

    public GuessResult makeGuess(Guess guess) {
        List<Game> games = numberDao.getAllGames();
        Round round = new Round();
        GuessResult result = new GuessResult();
        int exact = 0;
        int partial = 0;
        round.setGameId(guess.getGameId());
        round.setGuess(guess.getGuessAsString());
        round.setTime(Timestamp.valueOf(LocalDateTime.now()));
        Game game = games.stream()
                .filter(g -> g.getGameId() == guess.getGameId())
                .findFirst()
                .orElse(null);
        //game is null
        if (game == null) {
            result.setStatus(GuessStatus.Shame);
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

        if (exact == 4) {
            result.setStatus(GuessStatus.Win);
        }  else {
            result.setStatus(GuessStatus.Continue);
        }
        numberDao.addGame(game);
        numberDao.addRound(round);
        return result;
    }

    public List<Game> getAllGames() {
        return numberDao.getAllGames();
    }

    public List<Round> getRoundsById(int gameId) {
        return numberDao.getRoundsById(gameId);
    }
}
