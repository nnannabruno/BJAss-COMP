package core;

import java.util.Scanner;

public class ConsoleGame {
	boolean endRound = false;
	
	public void consoleGame() {
		//Playing Deck
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		//Player Deck
		Deck playerCards = new Deck();
		
		Deck dealerCards = new Deck();
		
		//Scanner userInput = new Scanner(System.in);
		
		System.out.println("Dealing...");
		
		//Player gets two cards
		
		playerCards.draw(playingDeck);				
		playerCards.draw(playingDeck);
		
		//Dealer gets two cards
		dealerCards.draw(playingDeck);
		dealerCards.draw(playingDeck);
		
		//Display dealer cards
		System.out.println("Dealer Hand: " + dealerCards.getCard(0).toString() + " and [hidden]");
		
		hitOrStand(playerCards, playingDeck);
						
		//See if dealer has more points than player	
		if((dealerCards.cardsValue() > playerCards.cardsValue())&&endRound == false){
			System.out.println("Dealer beats you " + dealerCards.cardsValue() + " to " + playerCards.cardsValue());
			endRound = true;
		}
		
		if(dealerCards.getCard(0).getRank() == Rank.A || dealerCards.getCard(1).getRank() == Rank.A) {
			 dealerHitSoft(dealerCards, playingDeck); 
		}else {
			 dealerHit(dealerCards, playingDeck); 
		}
		//Determine if dealer busted
		if((dealerCards.cardsValue()>21)&& endRound == false){
			System.out.println("Dealer Busts. You win!");
			endRound = true;
		}
		//Determine if push
		if((dealerCards.cardsValue() == playerCards.cardsValue()) && endRound == false){
			System.out.println("Split.");
			endRound = true;
		}
		//Determine if player wins
		if((playerCards.cardsValue() > dealerCards.cardsValue()) && endRound == false){
			System.out.println("You win the hand.");
			endRound = true;
		}
		else if(endRound == false){
			System.out.println("Dealer wins.");
		}

		//End of hand - put cards back in deck
		playerCards.moveAllToDeck(playingDeck);
		dealerCards.moveAllToDeck(playingDeck);
		System.out.println("End of Hand.");
			
		//userInput.close();
	}
	 
	public void dealerHit(Deck dealer, Deck main) {
		//Dealer hits at 16 stands at 17
				while(((dealer.cardsValue() < 17) && endRound == false)){
					dealer.draw(main);
					System.out.println("Dealer draws: " + dealer.getCard(dealer.deckSize()-1).toString());
				}
				System.out.println("/***********************************/");
				//Display dealer hand
				System.out.println("Dealers Hand:" + dealer.toString());
				//Display value of dealer
				System.out.println("Dealers hand value: " + dealer.cardsValue());
				System.out.println("/***********************************/");
	}
	
	public void dealerHitSoft(Deck dealer, Deck main) {
		//Dealer hits at soft 17
				while(((dealer.getCard(0).getRank() == Rank.A) && (dealer.cardsValue() <= 17) && endRound == false) || ((dealer.getCard(1).getRank() == Rank.A) && (dealer.cardsValue() <= 17) && endRound == false)){
					dealer.draw(main);
					System.out.println("Dealer draws: " + dealer.getCard(dealer.deckSize()-1).toString());
				}
				System.out.println("/***********************************/");
				//Display dealer hand
				System.out.println("Dealers Hand:" + dealer.toString());
				//Display value of dealer
				System.out.println("Dealers hand value: " + dealer.cardsValue());
				System.out.println("/***********************************/");
	}
	
	public void playerBlackJack(Deck player) {
		if ((player.cardsValue() == 21)) {
			System.out.println("You win the hand.");
			endRound = true;
		}
	}
	
	
	public void hitOrStand (Deck player, Deck main) {
		Scanner userInput = new Scanner(System.in);
		  while(true) {
			  
			System.out.println("Your Hand:" + player.toString());
			//Display Value
			System.out.println("Your hand is currently valued at: " + player.cardsValue());
			System.out.println("Would you like to (1)Hit or (2)Stand");
			int response = userInput.nextInt();	
			//They hit
			if(response == 1){
				player.draw(main);
				System.out.println("You draw a:" + player.getCard(player.deckSize()-1).toString());
				//Bust if they go over 21
				if(player.cardsValue() > 21){
					System.out.println("Bust. Currently valued at: " + player.cardsValue());
					endRound = true;
					break;
				}
			}
							
			//Stand
			if(response == 2){
				break;
			}
		  }
		  
		 // userInput.close();  
	 }
	
	 
}
