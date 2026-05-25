/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	LinkStack.java:
	=================================
	interface class for defining stack operations, 
	implemented by the CardStack as a linked list stack.
	these data structure layers are for modeling 
	the player's hand, NOT for modeling the deck
	LinkStack interface contains our method / function
	declarations for the CardStack class implementation */

package GameOfWar;

public interface LinkStack<Card> {
	void push(Card element) throws StackOverflowException;
	
	void pop() throws StackUnderflowException;
	
	Card top() throws StackUnderflowException;
	
	Card poptop() throws StackUnderflowException;
	
	int size();
	
	void clear();
	
	boolean isEmpty();
	
	boolean isFull();
	
}