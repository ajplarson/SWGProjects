package ajplarson.bullsandcows.models;

import java.sql.Timestamp;

/**
 * @author ajplarson
 */
public class Round {

    private int roundNumber;
    private int exact;
    private int partial;
    private Timestamp time;
    private Guess guess;
    private int gameId;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Guess getGuess() {
        return guess;
    }

    public void setGuess(Guess guess) {
        this.guess = guess;
    }

    public int getExact() {
        return exact;
    }

    public void setExact(int exact) {
        this.exact = exact;
    }

    public int getPartial() {
        return partial;
    }

    public void setPartial(int partial) {
        this.partial = partial;
    }

    public Round() {
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

}
