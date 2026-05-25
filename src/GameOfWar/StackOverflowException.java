/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	  StackOverflowException.java:
  	=================================
	  a custom defined StackOverflowException for our error handling
    a deliberate design choice, extending RuntimeException
    created to guard against invalid / illegal push and pop calls */

package GameOfWar;

public class StackOverflowException extends RuntimeException {
	//default unique serial ID to serialize StackOverflowException to written, physical disk
	private static final long serialVersionUID = 1L;

public StackOverflowException()
  {
    super();
  }

  public StackOverflowException(String message)
  {
    super(message);
  }
  
}