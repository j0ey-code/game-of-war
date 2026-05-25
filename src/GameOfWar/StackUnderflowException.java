/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

    StackUnderflowException.java:
	  =================================
	  a custom defined StackOverflowException for our error handling
    a deliberate design choice, extending RuntimeException
    created to guard against invalid / illegal push and pop calls */

package GameOfWar;

public class StackUnderflowException extends RuntimeException {
	//default unique serial ID to serialize StackUnderflowException to written, physical disk
	private static final long serialVersionUID = 1L;

public StackUnderflowException()
  {
    super();
  }

  public StackUnderflowException(String message)
  {
    super(message);
  }
  
}