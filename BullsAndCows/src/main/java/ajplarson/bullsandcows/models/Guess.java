package ajplarson.bullsandcows.models;

/**
 * @author ajplarson
 */
public class Guess {

    private int gameId;
    private String guessAsString;

    public Guess() {
    }

    public Guess(int gameId, String guessAsString) {
        this.gameId = gameId;
        this.guessAsString = guessAsString;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGuessAsString() {
        return guessAsString;
    }

    public void setGuessAsString(String guessAsString) {
        this.guessAsString = guessAsString;
    }

}
