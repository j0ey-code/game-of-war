/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	ArrDeck.java:
	=================================
	first concrete data structure implementation for the project,
	utilizing a basic array data structure initialized as a fixed
	array of 52 Card objects (see lines 22-29).
	accompanying methods for performing a variety of actions
	on a deck of cards (populate(), drawCard(), shuffleDeck(), etc.)
	both ArrDeck & ArrListDeck classes implementing DeckInterface,
	allowing for polymorphism and interchangeability in the program
	between differing, concrete back-end implementations */

package GameOfWar;

//IMPORTING ARRAY UTILITIES LIBRARIES
import java.util.Arrays;

public class ArrDeck implements DeckInterface {
	
	protected Card[] deckArr;
	protected int top = -1;
	protected int max = 52;
	
	public ArrDeck() {
		this.deckArr = new Card[max];
		
	}

	//FUNCTION TO POPULATE THE ARRAY WITH THE DECK OF CARDS -
	// - USING NESTED FOR LOOPS TO ASSIGN SUIT / FACE TO EACH CARD
	public void populate() throws StackOverflowException {
		for (int i = 0; i < 4; i++) {
			String suit = getSuit(i);
			if (suit != null) {
				for (int j = 2; j < 15; j++) {
					this.push(new Card(suit, j));

				}
			}
		}
		if (this.deckArr.length > 52) {
			throw new StackOverflowException("Too many cards!!");
		}
		
	}
	
	//PRIVATE METHOD TO RETRIEVE SUITS BASED ON INTEGERS 0 THROUGH 3 -
	// - IN ORDER TO ALLOW FOR QUICKLY FILLING THE DECK WITH THE - 
	// - NESTED FOR LOOPS IN THE populate() FUNCTION DIRECTLY ABOVE
	private String getSuit(int suitInt) {
		switch (suitInt) {
		case 0:
			return Card.CLUBS;
		case 1:
			return Card.HEARTS;
		case 2:
			return Card.DIAMONDS;
		case 3:
			return Card.SPADES;	
		}
		return null;
		
	}
	
	//FUNCTION TO RETRIEVE THE TOP CARD FROM THE ARRAY USING peek(), -
	// - POP THAT CARD FROM THE DECK, AND RETURN THE DRAWN CARD
	@Override
	public Card drawCard() {
		Card drawn = this.peek();
		this.pop();
		return drawn;
		
	}

	//FUNCTION TO SHUFFLE DECK A SPECIFIED AMOUNT OF TIMES AS THE INT PARAMETER; -
	// - WORKS BY SWAPPING TWO CARDS AT RANDOM INDICES THE SPECIFIED AMOUNT OF TIMES
	@Override
	public void shuffleDeck(int shuffleAmt) {
		for (int i = 0; i < shuffleAmt; i++) {
			int rand1 = numGen();
			int rand2 = numGen();
			if (rand1 != rand2) {
				//System.out.println("Random indices are... " + rand1	+ " and " + rand2);		
				Card temp = this.deckArr[rand1];
				this.deckArr[rand1] = this.deckArr[rand2];
				this.deckArr[rand2] = temp;
			} 	
		}
		
	}
	
	//RANDOM NUMBER GENERATOR METHOD FOR shuffleDeck() FUNCTION ABOVE
	private int numGen() {
		int rng = -1;
		do {
			rng = (int) (Math.random() * (52 - 0) + 0);
		} while (rng < 0 || rng > 51);
		return rng;
		
	}

	//FUNCTION TO RETURN THE DECK'S SIZE
	@Override
	public int deckSize() {
		return top + 1;
		
	}

	//PUSH FUNCTION
	@Override
	public void push(Card c) throws StackOverflowException {
		if (top >= max-1) {
			throw new StackOverflowException("Push attempted on a full stack.");
		} else {
			deckArr[++top] = c;
		}
		
	}

	//POP FUNCTION
	@Override
	public void pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException("Pop attempted on an empty stack.");
		}
		else {
			deckArr[top] = null;
			top--;
		}
		
	}

	//top() FUNCTION TO RETURN THE TOP CARD FROM THE ARRAY; - 
	// - DOES *NOT* ALSO PERFORM THE POP OR "DISCARD"!! - 
	// - IS **NOT** A --poptop()-- METHOD!!!
	@Override
	public Card peek() throws StackUnderflowException {
		Card topCard = null;
		if (this.isEmpty()) {
			throw new StackUnderflowException("Top attempted on an empty stack.");
		}
		else {
			topCard = deckArr[top];
		}
		return topCard;
		
	}

	//isEmpty() METHOD
	@Override
	public boolean isEmpty() {
		if (this.deckSize() == 0) {
			return true;
		} else {
			return false;
		}
	}

	//isFull() METHOD
	@Override
	public boolean isFull() {
		if (this.deckSize() == 52) {
			return true;
		} else {
			return false;
		}
	}

	//toString() METHOD
	@Override
	public String toString() {
		return "( Deck = " + Arrays.toString(deckArr) + " ); Top = " + top + ", Max = " + max + "  ";
	}
	
	
}