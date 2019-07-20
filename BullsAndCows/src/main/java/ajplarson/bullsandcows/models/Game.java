package ajplarson.bullsandcows.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ajplarson
 */
public class Game {

    private int gameId;
    private List<Character> guesses = new ArrayList<>();
    private String winningNumbers;
    private List<Round> rounds;

    public Game() {
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getIncorrectCount() {
        Set<Character> numbers = new HashSet<>();

        for (Character c : winningNumbers.toCharArray()) {
            numbers.add(c);
        }
        int initialSize = numbers.size();
        numbers.addAll(guesses);

        int finalSize = numbers.size();
        return finalSize - initialSize;
    }

    public int getRemainingNumbers() {
        List<Character> numbers = new ArrayList<>();
        for (Character c : winningNumbers.toCharArray()) {
            numbers.add(c); //get rid of commas
        }
        numbers.removeIf(item -> guesses.contains(item));
        return numbers.size();
    }

    public List<Character> getGuesses() {
        return new ArrayList<>(guesses);
    }

    public boolean add(Character number) {
        boolean exists = false;
        if (guesses.contains(number)) {
            exists = true;
        }
        guesses.add(number);
        return !exists;
    }
}
