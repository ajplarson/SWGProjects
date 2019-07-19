package ajplarson.bullsandcows.models;

/**
 * @author ajplarson
 */
public class GuessResult {

    private int guessesRemaining;
    private GuessStatus status = GuessStatus.NotFound;

    public int getGuessesRemaining() {
        return guessesRemaining;
    }

    public void setGuessesRemaining(int guessesRemaining) {
        this.guessesRemaining = guessesRemaining;
    }

    public GuessStatus getStatus() {
        return status;
    }

    public void setStatus(GuessStatus status) {
        this.status = status;
    }

}
