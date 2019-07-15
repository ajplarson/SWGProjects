package ajplarson.cribbage;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ajplarson
 */
public class ScoreTest {
    
    private Score score = new Score();
    
    public ScoreTest() {
    }

    
    @Test
    public void testScoreHand20(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(8, Suit.HEARTS));
        cards.add(new Card(8, Suit.SPADES));
        
        assertEquals(20, score.scoreHand(cards));
    }
    
    @Test
    public void testScoreHand8(){
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(1, Suit.CLUBS));
        cards.add(new Card(8, Suit.HEARTS));
        cards.add(new Card(3, Suit.SPADES));
        
        assertEquals(8, score.scoreHand(cards));
    }
    
    @Test
    public void testRunsScore14567() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(1, Suit.CLUBS));
        cards.add(new Card(4, Suit.HEARTS));
        cards.add(new Card(5, Suit.CLUBS));
        cards.add(new Card(6, Suit.HEARTS));
        cards.add(new Card(7, Suit.SPADES));
        
        assertEquals(4, score.getRunsScore(cards));
    }

    @Test
    public void testGetPairs() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(7, Suit.HEARTS));
        cards.add(new Card(7, Suit.CLUBS));
        cards.add(new Card(9, Suit.HEARTS));
        
        assertEquals(6, score.getPairsScore(cards));
    }
    
}
