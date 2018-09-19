package core;

public class Card {
	Suit suit;
	Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String toString() {
		return this.suit.toString() + this.rank.toString();
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
}
