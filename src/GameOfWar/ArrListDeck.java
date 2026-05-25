/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	ArrListDeck.java:
	=================================
	second concrete data structure implementation for the project,
	utilizing a dynamic, Java ArrayList data structure to
	hold the deck of cards and perform relevant actions / functions
	upon it, based on the DeckInterface specifications
	both ArrDeck & ArrListDeck classes implementing DeckInterface,
	allowing for polymorphism and interchangeability in the program
	between differing, concrete back-end implementations */

package GameOfWar;

//IMPORTING ARRAYLIST UTILITIES LIBRARIES
import java.util.ArrayList;

public class ArrListDeck implements DeckInterface {
	
	protected ArrayList<Card> deckArrList;
	protected int top = -1;
	//NO MAX SIZE FOR AN ARRAYLIST IMPLEMENTATION
	
	public ArrListDeck() {
		this.deckArrList = new ArrayList<Card>();
		
	}
	
	//FUNCTION TO POPULATE THE ARRAY WITH THE DECK OF CARDS -
	// - USING NESTED FOR LOOPS TO ASSIGN SUIT / FACE TO EACH CARD
	public void populate() /*throws StackOverflowException*/ {
		for (int i = 0; i < 4; i++) {
			String suit = getSuit(i);
			if (suit != null) {
				for (int j = 2; j < 15; j++) {
					this.push(new Card(suit, j));
				
					
				}
			}
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
				Card temp = this.deckArrList.get(rand1);
				this.deckArrList.set(rand1, this.deckArrList.get(rand2));
				this.deckArrList.set(rand2, temp);
			} 	
		}
		
	}
	
	//RANDOM NUMBER GENERATOR METHOD FOR shuffleDeck() FUNCTION ABOVE
	private int numGen() {
		int rng = -1;
		do {
			rng = (int) (Math.random() * (this.deckSize() - 0) + 0);
		} while (rng < 0 || rng >= this.deckSize());
		return rng;
			
	}

	//FUNCTION TO RETURN THE DECK'S SIZE
	@Override
	public int deckSize() {
		if (this.isEmpty()) {
			return 0;
		}
		int i;
		for (i = 0; i < deckArrList.size(); i++) {
			//COUNTING...
		}
		return i;
		
	}

	//PUSH FUNCTION
	@Override
	public void push(Card c) throws StackOverflowException {
		deckArrList.add(c);
		top++;
		
	}
	
	//POP FUNCTION
	@Override
	public void pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException("Pop attempted on an empty stack.");
		}
		else {
			deckArrList.remove(top);
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
			topCard = deckArrList.get(top);
		}
		return topCard;
		
	}
	
	//EXPLICIT METHOD TO CLEAR THE ARRAYLIST
	public void clear() {
		deckArrList.clear();
		
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	//AN ARRAYLIST IS NEVER FULL
	@Override
	public boolean isFull() {
		return false;
	}

	//toString() METHOD
	@Override
	public String toString() {
		return "( Deck = " + deckArrList + " ); Top = " + top + ", Size = " + this.deckSize() + " ";
	}
	
	
	
	
}