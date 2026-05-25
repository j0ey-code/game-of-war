/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	Card.java:
	=================================
	the atomic data type for our game program
	the "Card" class / object encapsulates a "suit" and a "face"
	attribute - the defining features of a playing card
	additionally, we have included short-hand methods
	for some basic card actions (getSuit(), getFace(), etc.),
	as well as a toString() function and in-file enumerations
	for our suit and face variable attributes */

package GameOfWar;


public class Card {

	public static final String CLUBS = "Clubs";
	public static final String HEARTS = "Hearts";
	public static final String DIAMONDS = "Diamonds";
	public static final String SPADES = "Spades";
	public static final int ACE = 14;
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int JACK = 11;

	private String suit;
	private int face;

	public Card(String suit, int face) {
		this.suit = suit;
		this.face = face;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	//MODIFIED SLIGHTLY TO PROVIDE CLEANER LOOKING OUTPUT
	public String toString() {
		if (face > 10 && face < 15) {
			switch (face) {
			case 11:
				String jack = "{ Jack }";
				return jack + " of " + suit;
			case 12:
				String queen = "[ Queen ]";
				return queen + " of " + suit;
			case 13:
				String king = "( King )";
				return king + " of " + suit;
			case 14:
				String ace = "< Ace >";
				return ace + " of " + suit;
			default:
				break;
			}
		}
		return face + " of " + suit;
		
	}
	
}
