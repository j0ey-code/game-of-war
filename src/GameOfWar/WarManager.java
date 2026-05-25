/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	WarManager.java:
	=================================
	WarManager class, containing all core functions and methods
	which orchestrate and drive the entire program, besides the 
	main() function within CardDeckTester.java obviously, of course
	has all the essential logical and conditional methods for
	running the card game of war, provided the data structures / classes
	for our player, player hands, cards, and card decks. */

package GameOfWar;

public class WarManager {
	//CRITICAL OBJECT VARIABLES CREATED HERE
	public Player p1;
	public Player p2;
	DeckInterface theDeck;
	
	//FIGURE OUT THIS CUSTOM CONSTRUCTOR LATER!!
	//never finished this, whoops...
	/*public WarManager(DeckInterface deck) {
		p1 = this.p1;
		p2 = this.p2;
		deck = this.theDeck;
		
	}*/

	//INSTANTIATE AND SHUFFLE THE DECK; 52 HARDCODED SHUFFLES
	//PLAYER OBJECTS ASSIGNED HARDCODED NAMES AND INSTANTIATED
	public void setup() {
		theDeck = new ArrDeck();
		theDeck.populate();
		theDeck.shuffleDeck(52);
		//System.out.println(theDeck.isFull());
		//System.out.println(theDeck.isEmpty());
		//System.out.println(theDeck.toString());
		p1 = new Player("Player 1");
		p2 = new Player("Player 2");
		
	}
	
	//FUNCTION TO DEAL CARDS TO EACH PLAYER
	public void deal() {
		for (int i = 0; i < 52; i++) {
			int modTemp = i % 2;
			if (modTemp == 0) {
				p1.drawStack.push(theDeck.drawCard());
				
			} else {
				p2.drawStack.push(theDeck.drawCard());
				
			}
		}
		System.out.printf("Cards evenly dealt to each player. The game of war begins...\n\n");
	
	}
	
	//FUNCTION TO RUN ACTUAL SIMULATION OF GAME
	public void play() {
		//winner VARIABLE CREATED TO ALLOW FOR RECURSIVENESS OF WAR() METHOD IN THE EVENT OF A DOUBLE OR MORE WAR CALL
		Player winner = null;
		//EXTRA CONDITIONAL I SUPPOSE?? CAN NEVER BE TOO SAFE ~
		//do... while WOULD PROBABLY BE MORE FITTING I GUESS, WHATEVER
		while (!this.isGameOver()) {
			Card p1Card = p1.draw();
			Card p2Card = p2.draw();
			System.out.println(p1.getName() + " has played the " + p1Card + "; " + p2.getName() + " has played the " + p2Card + ".");
			//if FOR PLAYER ONE WINNING A BATTLE HAND
			if (p1Card.getFace() > p2Card.getFace()) {
				p1.discard(p2Card);
				p1.discard(p1Card);
				System.out.println(p1.getName() + " receives the cards; the " + p2Card + " and " + p1Card + ".");
				System.out.println(p1.getName() + " has " + (p1.drawStack.size() + p1.discardStack.size()) + " cards.");
				if (p2.hasCards() == false) {
					break;
				}
				//else if FOR PLAYER TWO WINNING A BATTLE HAND
			} else if (p2Card.getFace() > p1Card.getFace()) {
				p2.discard(p1Card);
				p2.discard(p2Card);
				System.out.println(p2.getName() + " receives the cards; the " + p1Card +" and " + p2Card + ".");
				System.out.println(p2.getName() + " has " + (p2.drawStack.size() + p2.discardStack.size()) + " cards.");
				if (p1.hasCards() == false) {
					break;
				}
				//else FOR A WAR() METHOD CONDITION; THE PLAYERS BOTH HAVE CARDS OF EQUAL FACE VALUE
			} else {
				winner = war(p1Card, p2Card);
				
			}
			
		}
		//WINNER OF THE WHOLE GAME CONDITIONS, IN THE EVENT THAT isGameOver() FINALLY RETURNS TRUE TO THE WHILE LOOP ABOVE
		if (p1.hasCards() == true) {
			System.out.println(p2.getName() + " is out of cards. Total card count is " + (p2.drawStack.size() + p2.discardStack.size()) + ".");
			System.out.println(p1.getName() + " has won the game with all cards in hand, " + (p1.drawStack.size() + p1.discardStack.size()) + "!!");
		} else {
			System.out.println(p1.getName() + " is out of cards. Total card count is " + (p1.drawStack.size() + p1.discardStack.size()) + ".");
			System.out.println(p2.getName() + " has won the game with all cards in hand, " + (p2.drawStack.size() + p2.discardStack.size()) + "!!");
		}
		
	}
	
	//PRIVATE METHOD TO FURTHER ABSTRACT THE PROCESS OF A GAME OVER CONDITION
	private boolean isGameOver() {
		if (p1.hasCards() == false || p2.hasCards() == false) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public Player war(Card p1C, Card p2C) {
		//winner VARIABLE FOR EASIER DISCARD OF THE CARDS OBTAINED DURING A WAR, - 
		// - AND FOR RECURSIVENESS, IN THE EVENT OF A DOUBLE OR MORE WAR
		Player winner = null;
		int drawCtr = 0;
		Card[] p1Unit = new Card[3];
		Card[] p2Unit = new Card[3];
		if (!this.isGameOver()) {
			System.out.printf("\nWar!!\n");
			while (p1.hasCards() && p2.hasCards() && (drawCtr < 3)) {
				p1Unit[drawCtr] = p1.draw();
				p2Unit[drawCtr] = p2.draw();
				drawCtr++;
			}
			//System.out.println("Both players have now put down the preliminary three cards each for the war.");
		}
		if (!this.isGameOver()) {
			Card p1Cmd = p1.draw();
			Card p2Cmd = p2.draw();
			System.out.println(p1.getName() + " has played the " + p1Cmd + "; " + p2.getName() + " has played the " + p2Cmd + ".");
			if (p1Cmd.getFace() > p2Cmd.getFace()) {
				//NOW UN-NECESSARY CODE WITH PLAYER winner VARIABLE
				//System.out.println(p1.getName() + " has won the war!");
				//System.out.printf(p1.getName() + " receives all the cards.\n\n");
				/*p1.discard(p2C);
				p1.discard(p1C);
				for (int j = 2; j > -1; j--) {
					p1.discard(p2Unit[j]);
					p1.discard(p1Unit[j]);

				}*/
				p1.discard(p2Cmd);
				p1.discard(p1Cmd);
				winner = p1;

			} else if (p2Cmd.getFace() > p1Cmd.getFace()) {
				//NOW UN-NECESSARY CODE WITH PLAYER winner VARIABLE
				//System.out.println(p2.getName() + " has won the war!");
				//System.out.printf(p2.getName() + " receives all the cards.\n\n");
				/*p2.discard(p1C);
				p2.discard(p2C);
				for (int j = 2; j > -1; j--) {
					p2.discard(p1Unit[j]);
					p2.discard(p2Unit[j]);

				}*/
				p2.discard(p1Cmd);
				p2.discard(p2Cmd);
				winner = p2;

			} else {
				//System.out.println("RECURSIVE CALL W/ THESE CARDS: " + p1Cmd + " / " + p2Cmd);
				winner = war(p1Cmd, p2Cmd);

			}

		} else {
			if (p1.hasCards()) {
				//NOW UN-NECESSARY CODE WITH PLAYER winner VARIABLE
				/*p1.discard(p1C);
				p1.discard(p2C);
				if (drawCtr > 0) {
					for (int i = 0; i < drawCtr; i++) {
						p1.discard(p1Unit[i]);
						p1.discard(p2Unit[i]);
					}
				}*/
				System.out.println(p2.getName() + " does not have enough remaining cards to commence war.");
				winner = p1;

			} else {
				//NOW UN-NECESSARY CODE WITH PLAYER winner VARIABLE
				/*p2.discard(p1C);
				p2.discard(p2C);
				if (drawCtr > 0) {
					for (int i = 0; i < drawCtr; i++) {
						p2.discard(p1Unit[i]);
						p2.discard(p2Unit[i]);
					}
				}*/
				System.out.println(p1.getName() + " does not have enough remaining cards to commence war.");
				winner = p2;
				
			}
		}
		//MOVING THE CARDS TO THE winner VARIABLE'S DISCARD STACK, THEREBY BEING ABLE TO FEED winner BACK AS THE 
		winner.discard(p1C);
		winner.discard(p2C);
		for (int i = 0; i < drawCtr; i++) {
			winner.discard(p1Unit[i]);
			winner.discard(p2Unit[i]);
		}
		System.out.println(winner.getName() + " has won the war(s)!");
		System.out.printf(winner.getName() + " receives all of the cards and now has a total of " + (winner.drawStack.size() + winner.discardStack.size()) + " cards!\n\n");
		return winner;
		
	}

}

