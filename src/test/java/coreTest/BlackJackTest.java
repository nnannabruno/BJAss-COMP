package coreTest;



import core.BlackJack;
import core.Card;
import core.ConsoleGame;
import core.Deck;
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
		
		assertEquals("\n" + "CTWO" + "\n" + "DA", playerCards.toString());
	}
	
	public void testDealerVisibleCard() {
		Deck dealerCards = new Deck();
		dealerCards.addCard(new Card(Suit.C, Rank.SEVEN));
        dealerCards.addCard(new Card(Suit.S, Rank.J));
		
		assertEquals( "CSEVEN", dealerCards.getCard(0).toString());
	}
	
	public void testPlayerCanHit() {
		ConsoleGame game = new ConsoleGame();
		Deck deck = new Deck();
		deck.addCard(new Card(Suit.S, Rank.J));
		Deck playerCards = new Deck();
		playerCards.addCard(new Card(Suit.H, Rank.SEVEN));
        playerCards.addCard(new Card(Suit.D, Rank.Q));
        game.hitOrStand(playerCards, deck);
		assertEquals(3, playerCards.deckSize());
	}
	

	public void testPlayerCanStand() {
		ConsoleGame game = new ConsoleGame();
		Deck deck = new Deck();
		deck.addCard(new Card(Suit.S, Rank.J));
		Deck playerCards = new Deck();
		playerCards.addCard(new Card(Suit.H, Rank.SEVEN));
        playerCards.addCard(new Card(Suit.D, Rank.Q));
        game.hitOrStand(playerCards, deck);
		assertEquals(2, playerCards.deckSize());
	}
	
	public void testPlayerCanHitMultiple() {
		ConsoleGame game = new ConsoleGame();
		Deck deck = new Deck();
		deck.addCard(new Card(Suit.S, Rank.NINE));
		deck.addCard(new Card(Suit.D, Rank.J));
		Deck playerCards = new Deck();
		playerCards.addCard(new Card(Suit.H, Rank.SEVEN));
        playerCards.addCard(new Card(Suit.D, Rank.TWO));
        game.hitOrStand(playerCards, deck);
		assertEquals(4, playerCards.deckSize());
	}
	
	public void testPlayerBustDealerWins() {
		Deck dealerCards = new Deck();
		dealerCards.addCard(new Card(Suit.S, Rank.J));
		Deck playerCards = new Deck();
		playerCards.addCard(new Card(Suit.H, Rank.SEVEN));
        playerCards.addCard(new Card(Suit.D, Rank.Q));
        playerCards.addCard(new Card(Suit.C, Rank.J));
		assertTrue("Dealer wins", dealerCards.cardsValue() < playerCards.cardsValue());
	}
	
	
	public void testDealerHit() {
		ConsoleGame game = new ConsoleGame();
		Deck deck = new Deck();
		deck.addCard(new Card(Suit.S, Rank.FOUR));
		Deck dealerCards = new Deck();
		dealerCards.addCard(new Card(Suit.H, Rank.FIVE));
        dealerCards.addCard(new Card(Suit.D, Rank.Q));
        game.dealerHit(dealerCards, deck);
		assertEquals(3, dealerCards.deckSize());
	}
	
	public void testDealerHitSoft() {
		ConsoleGame game = new ConsoleGame();
		Deck deck = new Deck();
		deck.addCard(new Card(Suit.C, Rank.THREE));
		Deck dealerCards = new Deck();
		dealerCards.addCard(new Card(Suit.H, Rank.SIX));
        dealerCards.addCard(new Card(Suit.D, Rank.A));
        game.dealerHitSoft(dealerCards, deck);
		assertEquals(3, dealerCards.deckSize());
	}
	
	public void testDealerHitMultiple() {
		ConsoleGame game = new ConsoleGame();
		Deck deck = new Deck();
		deck.addCard(new Card(Suit.S, Rank.FOUR));
		deck.addCard(new Card(Suit.S, Rank.SIX));
		Deck dealerCards = new Deck();
		dealerCards.addCard(new Card(Suit.H, Rank.FIVE));
        dealerCards.addCard(new Card(Suit.D, Rank.FIVE));
        game.dealerHit(dealerCards, deck);
		assertEquals(4, dealerCards.deckSize());
	}
	
	public void testDealerBust(){
		Deck dealerCards = new Deck();
		dealerCards.addCard(new Card(Suit.S, Rank.J));
		dealerCards.addCard(new Card(Suit.S, Rank.K));
		dealerCards.addCard(new Card(Suit.C, Rank.NINE));	
		assertTrue("Player Wins", dealerCards.cardsValue() > 21);	
	}
	
	
	public void testChoiceInput() {
		assertEquals(true, 1 == BlackJack.choiceInput() || 2 == BlackJack.choiceInput());
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
	
	 public void testPlayerInitialBlackJack() {
	        Deck player = new Deck();
	        player.addCard(new Card(Suit.C, Rank.J));
	        player.addCard(new Card(Suit.S, Rank.A));
	        assertEquals(21, player.cardsValue());
	 }

	 public void testDealerInitialBlackJack() {
	        Deck dealer = new Deck();
	        dealer.addCard(new Card(Suit.H, Rank.J));
	        dealer.addCard(new Card(Suit.S, Rank.NINE));
	        dealer.addCard(new Card(Suit.H, Rank.TWO));
	        assertEquals(21, dealer.cardsValue());
	 }
	 
	 public void testPlayerHasBlackJack() {
	        Deck player = new Deck();
	        player.addCard(new Card(Suit.C, Rank.J));
	        player.addCard(new Card(Suit.S, Rank.A));
	        Deck dealer = new Deck();
	        dealer.addCard(new Card(Suit.H, Rank.J));
	        dealer.addCard(new Card(Suit.S, Rank.NINE));
	        assertTrue(player.cardsValue() == 21);
	 }

	 public void testDealerHasBlackJack() {
		 	Deck player = new Deck();
	        player.addCard(new Card(Suit.C, Rank.J));
	        player.addCard(new Card(Suit.S, Rank.SIX));
	        Deck dealer = new Deck();
	        dealer.addCard(new Card(Suit.H, Rank.J));
	        dealer.addCard(new Card(Suit.S, Rank.NINE));
	        dealer.addCard(new Card(Suit.H, Rank.TWO));
	        assertTrue(dealer.cardsValue() == 21);
	 }
	 
	 public void testBlackJackNoBustDealerWins() {
		 	Deck player = new Deck();
	        player.addCard(new Card(Suit.C, Rank.J));
	        player.addCard(new Card(Suit.S, Rank.SIX));
	        Deck dealer = new Deck();
	        dealer.addCard(new Card(Suit.H, Rank.J));
	        dealer.addCard(new Card(Suit.S, Rank.EIGHT));
	        dealer.addCard(new Card(Suit.H, Rank.A));
	        assertTrue((dealer.cardsValue() > player.cardsValue()) && (dealer.cardsValue() <= 21));
	 }
	 
	 public void testBlackJackNoBustPlayerWins() {
		 	Deck player = new Deck();
	        player.addCard(new Card(Suit.C, Rank.J));
	        player.addCard(new Card(Suit.S, Rank.A));
	        Deck dealer = new Deck();
	        dealer.addCard(new Card(Suit.H, Rank.J));
	        dealer.addCard(new Card(Suit.S, Rank.EIGHT));
	        dealer.addCard(new Card(Suit.H, Rank.A));
	        assertTrue((dealer.cardsValue() < player.cardsValue()) && (player.cardsValue() <= 21));
	 }

}
