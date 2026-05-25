/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	Player.java:
	=================================
	a Player class to hold relevant data about the Player
	including their name and information about their current
	hand of cards via the CardStack<Card> data structures, 
	drawStack and discardStack, thereby modeling the player's hand.
	Drawing pulls from drawStack and, if empty, fillDrawStack() flips 
	the entire discard pile back on top of it (preserving card order by 
	pushing 1-by-1, which reverses the stack naturally). 
	Won cards are always re-directed to the discardStack via discard().
	The hasCards() method checks both of the Player's stacks / their full hand. */

package GameOfWar;

public class Player {
	//CRITICAL VARIABLES FOR OUR PLAYER OBJECT
	public String nameStr = "Default Player";
	public LinkStack<Card> drawStack = new CardStack<Card>();
	public LinkStack<Card> discardStack = new CardStack<Card>();
	
	//CONSTRUCTOR FOR PLAYER ALLOWING CUSTOM NAME TO BE FED IN AS A PARAMETER
	public Player(String name) {
		this.nameStr = name;
		
	}
	
	//GETTER FOR JUST THE PLAYER NAME
	public String getName() {
		return this.nameStr;
		
	}
	
	//MASTER CALL FUNCTION TO REFILL OUR DRAW STACK FROM THE DISCARD PILE IN THE EVENT OF AN EMPTY HAND
	public void fillDrawStack() {
		if (drawStack.isEmpty()) {
			flipStack(discardStack);
		}
		
	}
	
	//PRIVATE METHOD TO REFILL THE DRAW STACK (IN CONJUCTION WITH ITS MASTER CALL DIRECTLY ABOVE) -
	// - WHILE SIMULTANEOUSLY REVERSING THE ORDER OF THE STACK, TO MAINTAIN PLAY ORDER OF THE CARDS
	private void flipStack(LinkStack<Card> pile) {
		if (pile.isEmpty()) {
			return;
		} 
		drawStack.clear();
		//System.out.println("flipStack has " + pile.size() + " cards to move.");
		//int counter = 0;
		while (pile.isEmpty() != true) {
			drawStack.push(pile.top());
			pile.pop();
			//counter++;
		}
		//System.out.println("flipStack has moved " + counter + " cards.");
		pile.clear();
		//flipStack(pile);
		//insertAtBottom(pile, temp);
		
	}
	
	//UNUSED CODE; NOW UN-NECESSARY UPON TWEAKING THE flipStack() METHOD ABOVE
	/*private void insertAtBottom(LinkStack<Card> pile, Card cardInst) {
		if (pile.isEmpty()) {
			pile.push(cardInst);
		} else {
			Card temp = pile.top();
			discardStack.pop();
			insertAtBottom(pile, cardInst);
			pile.push(temp);
		}
		
	}*/
	
	//FUNCTION TO DRAW A CARD
	public Card draw() {
		Card drawn;
		if (drawStack.isEmpty() != true) {
			drawn = drawStack.top();
			drawStack.pop();
			return drawn;
			
		} else {
			this.fillDrawStack();
			drawn = drawStack.top();
			drawStack.pop();
			return drawn;
			
		}
		
	}
	
	//FUNCTION TO DISCARD A CARD AND PUSH IT TO THE PLAYER'S DISCARD PILE
	public void discard(Card usedCard) {
		discardStack.push(usedCard);
		
	}

	//toString() METHOD
	@Override
	public String toString() {
		int totalCards = drawStack.size() + discardStack.size();
		return "Player: Name = " + nameStr + ", Cards (Total) = " + totalCards + " ] ";
	}
	
	//FUNCTION TO SEE IF A PLAYER HAS ANY CARDS REMAINING
	public boolean hasCards() {
		if (drawStack.size() != 0 || discardStack.size() != 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	
}