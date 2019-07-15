/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.cribbage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class Round {
    private static final int numberOfSuits = 4;
    private static final int numberOfCardsPerSuit = 13;
    private List<Card> deck;
    private List<Card> dealerHand;
    private List<Card> ponyHand;
    private List<Card> crib;

    public Round() {
        this.deck = setUpDeck();
        ponyHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        crib = new ArrayList<>();
    }
    
    public void run(){
        deck = shuffleDeck(deck);
        deal();

        
        crib.addAll(discardTwo(true));
        crib.addAll(discardTwo(false));
        
        printDeck(dealerHand);
        printDeck(ponyHand);
        printDeck(crib);
    }
    
    public void printDeck(List<Card> deck){
        System.out.println("\n=====");
        deck.stream()
                .forEach(i -> System.out.println(i.getValue()+" "+i.getSuit()));
    }
    
    
    public List<Card> shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
        return deck;
    }
    
    public void deal() {
        for (int i = 11; i >= 0; i--) {
            if(i % 2 == 0) {
                dealerHand.add(deck.get(i));
            } else {
                ponyHand.add(deck.get(i));
            }
            deck.remove(i);
        }  
    }
    
    public List<Card> setUpDeck() {
        List<Card> freshDeck = new ArrayList<>();
        Suit currentSuit = Suit.CLUBS;
        for(int i = 0; i < numberOfSuits; i++) {
            if(i == 1){
                currentSuit = Suit.DIAMONDS;
            }else if(i == 2){
                currentSuit = Suit.HEARTS;
            }else if(i == 3){
                currentSuit = Suit.SPADES;
            }
            for(int j = 1; j <= numberOfCardsPerSuit; j++) {
                freshDeck.add(new Card(j, currentSuit));
            }
        }
        return freshDeck;
    }
    
    public List<Card> discardTwo(boolean isDealer) {
        List<Card> discards = new ArrayList<>();
        if(isDealer == true) {
            discards.add(dealerHand.get(5));
            discards.add(dealerHand.get(4));
            dealerHand.remove(5);
            dealerHand.remove(4);
        } else {
            discards.add(ponyHand.get(5));
            discards.add(ponyHand.get(4));
            ponyHand.remove(5);
            ponyHand.remove(4);
        }
        return discards;
    }
}
