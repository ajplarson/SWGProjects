package ajplarson.cribbage;

public class Game {
    private int playerOneScore;
    private int playerTwoScore;
    private boolean isDealer;
    
    public static void main(String[] args){
        Round round = new Round();
        round.run();
    }
    
}
