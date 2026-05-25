/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	CardStack.java:
	=================================
	concrete data structure implementation (as a linked
	list stack) of the binding LinkStack interface class / file
	CardStack implements the stack through a linked list,
	where top is always the head node; push operations
	pre-pend a new node, pop moves the top pointer forward,
	and size simply iterates the stack, counting nodes.
	these linked list stack data structures are to
	model the hand of a player, rather than the deck */

package GameOfWar;

//template class for stack interface to be implemented; serves as our LinkedStack
public class CardStack<Card> implements LinkStack<Card> {

	protected LLNode<Card> top;
	
	public CardStack() {
		top = null;
		
	}
	
	@Override
	public void push(Card element) throws StackOverflowException {
		LLNode<Card> newNode = new LLNode<Card>(element);
		newNode.setLink(top);
		top = newNode;
		
	}

	@Override
	public void pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Pop failed. Empty stack.");
		} else {
			top = top.getLink();
		}
		
	}

	@Override
	public Card top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Top failed. Empty stack.");
		} else {
			return top.getInfo();
		}
	}

	@Override
	public Card poptop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Pop and top failed. Empty stack.");
		} else {
			this.pop();
			return top.getInfo();
		}
	}

	@Override
	public int size() {
		int ctr = 0;
		LLNode<Card> item = top;
		if (item != null) {
			do {
				ctr++;
				item = item.link;
				
			} while (item != null);
		}
		return ctr;
		
	}

	@Override
	public void clear() {
		if (top != null) {
			while (top.getLink() != null) {
				this.pop();
			
			} 
		}
		top = null;
		
	}
	
	//CUSTOM toString() METHOD
	@Override
	public String toString() {
		String builtStr = "LinkedStack [ ";
		String divvy = "";
		LLNode<Card> item = top;
		if (item != null) {
			do {
				builtStr += divvy + item.getInfo();
				item = item.link;
				divvy = " : ";
				
			} while (item != null);
		}
		builtStr += " ] ";
		return builtStr;
		
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	//A LINKED STACK IS NEVER FULL
	@Override
	public boolean isFull() {
		return false;
	}
	
	
}