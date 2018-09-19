package coreTest;

import core.Rank;
import core.Suit;
import junit.framework.TestCase;

public class BlackJackTest extends TestCase {

	
	public void testDeckCardCount() {
		Deck deck = new Deck();
		deck.createFullDeck();
		assertEquals(52, deck.deckSize());
	}
	
	
	public void testShuffle() {
		Deck deck = new Deck();
		deck.createFullDeck();
		Card card = deck.getCard(0);
		deck.shuffle();
		assertEquals(false, card == deck.getCard(0));	
	}
	
	public void testPlayerVisibleCard() {
		Deck playerCards = new Deck();
		playerCards.addCard(new Card(Suit.C, Rank.TWO));
        playerCards.addCard(new Card(Suit.D, Rank.A));
		playerCards.toString();
	}
	
	public void testChoiceInput() {
		BlackJack blackJack =  new BlackJack();
		assertEquals(true, 1 == blackJack.choiceInput() || 2 == blackJack.choiceInput());
	}
	
	 
	 public void testAceIsOne() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.C, Rank.TWO));
	        deck.addCard(new Card(Suit.D, Rank.A));
	        deck.addCard(new Card(Suit.H, Rank.K));
	        assertEquals(13, deck.cardsValue());
	 }
	 
	 
	 public void testAceIsEleven() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.C, Rank.TWO));
	        deck.addCard(new Card(Suit.D, Rank.THREE));
	        deck.addCard(new Card(Suit.H, Rank.FIVE));
	        deck.addCard(new Card(Suit.H, Rank.A));
	        assertEquals(21, deck.cardsValue());
	 }
	 
	 public void testTwoAcesInHand() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.C, Rank.A));
	        deck.addCard(new Card(Suit.H, Rank.A));
	        assertEquals(12, deck.cardsValue());
	 }
	 
	 public void testTwoAcesCountAsOne() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.C, Rank.A));
	        deck.addCard(new Card(Suit.H, Rank.A));
	        deck.addCard(new Card(Suit.S, Rank.J));
	        deck.addCard(new Card(Suit.D, Rank.FIVE));
	        assertEquals(17, deck.cardsValue());
	 }
	 
	 
	 public void testAceCountAsElevenThenOne() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.C, Rank.A));
	        assertEquals(11, deck.cardsValue());
	        deck.addCard(new Card(Suit.D, Rank.J));
	        deck.addCard(new Card(Suit.H, Rank.J));
	        assertEquals(21, deck.cardsValue());
	 }
	 
	 public void testJackCount() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.C, Rank.J));
	        assertEquals(10, deck.cardsValue());
	 }
	 
	 public void testKingCount() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.H, Rank.K));
	        assertEquals(10, deck.cardsValue());
	 }
	 
	 
	 public void testQueenCount() {
	        Deck deck = new Deck();
	        deck.addCard(new Card(Suit.D, Rank.Q));
	        assertEquals(10, deck.cardsValue());
	 }
	

}
