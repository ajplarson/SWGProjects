package ajplarson.bullsandcows.models;

import java.sql.Timestamp;

/**
 * @author ajplarson
 */
public class Round {

    private int roundNumber;
    private String guess;
    private int exact;
    private int partial;
    private Timestamp time;
    private int gameId;

    public Round() {
    }

    public Round(int roundNumber, int exact, int partial, Timestamp time, String guess, int gameId) {
        this.roundNumber = roundNumber;
        this.exact = exact;
        this.partial = partial;
        this.time = time;
        this.guess = guess;
        this.gameId = gameId;
    }

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

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
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

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

}
