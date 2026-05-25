/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	LLNode.java:
	=================================
	atomic, basic, generic linked-list node.
	by usage of the <T> generic type parameter for our
	node, we may wrap any kind of data - and so,
	we encapsulate our other atomic data type, Card,
	within our node as the data it will carry.
	LLNode is a standard linked list node, holding the data
	of its type within the "info" variable and a pointer to the
	next node in the linked list through the "link" variable */

package GameOfWar;

public class LLNode<T> {
	protected LLNode<T> link;
	protected T info;

	public LLNode(T info) {
		this.info = info;
		link = null;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	public void setLink(LLNode<T> link) {
		this.link = link;
	}

	public LLNode<T> getLink() {
		return link;
	}

}