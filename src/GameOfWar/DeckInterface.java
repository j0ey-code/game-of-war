/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	DeckInterface.java:
	=================================
	the interface class for the emulation of
	the game program's deck of cards.
	allows interchangeability between the ArrDeck
	and ArrListDeck implementations.
	card deck variable "theDeck" declared as a
	DeckInterface object within the WarManager
	class - i.e. programming to an abstraction */

package GameOfWar;

public interface DeckInterface {
	public void populate() throws StackOverflowException;
	
	public Card drawCard();
	
	public void shuffleDeck(int shuffleAmt);
	
	public int deckSize();
	
	void push(Card c) throws StackOverflowException;
	
	void pop() throws StackUnderflowException;
	
	Card peek() throws StackUnderflowException;
	
	boolean isEmpty();
	
	boolean isFull();
	
	
}