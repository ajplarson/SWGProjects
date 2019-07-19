package ajplarson.bullsandcows.models;

/**
 * @author ajplarson
 */
public class Guess {

    private int guessId;
    private String guessAsString;

    public Guess() {
    }

    public int getGuessId() {
        return guessId;
    }

    public void setGuessId(int guessId) {
        this.guessId = guessId;
    }

    public String getGuessAsString() {
        return guessAsString;
    }

    public void setGuessAsString(String guessAsString) {
        this.guessAsString = guessAsString;
    }

}
