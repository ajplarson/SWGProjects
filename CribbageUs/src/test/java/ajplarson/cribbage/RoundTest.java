/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.cribbage;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ajplarson
 */
public class RoundTest {
    
    public RoundTest() {
    }

    
    @Test
    public void testFreshDeck() {
        Round round = new Round();
        List<Card> cards = round.setUpDeck();
        System.out.println("");
    }
    
    @Test
    public void testDeal(){
       Round round = new Round();
       List<Card> cards = round.setUpDeck();
       round.deal();
    }
    
}
