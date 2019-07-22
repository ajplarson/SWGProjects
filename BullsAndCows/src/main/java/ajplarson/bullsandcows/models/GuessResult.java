package ajplarson.bullsandcows.models;

/**
 * @author ajplarson
 */
public class GuessResult {

    private GuessStatus status = GuessStatus.NotFound;
    private int partialGuess;
    private int exactGuess;

    public int getPartialGuess() {
        return partialGuess;
    }

    public void setPartialGuess(int partialGuess) {
        this.partialGuess = partialGuess;
    }

    public int getExactGuess() {
        return exactGuess;
    }

    public void setExactGuess(int exactGuess) {
        this.exactGuess = exactGuess;
    }


    public GuessStatus getStatus() {
        return status;
    }

    public void setStatus(GuessStatus status) {
        this.status = status;
    }

}
