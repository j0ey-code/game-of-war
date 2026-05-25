/*	j0ey-code || Sept. 2024
  	Game of War Simulation in Java

	MAIN FILE || CardDeckTester.java:
	=================================
	the official program file, where the main function lives
	"CardDecKTester main() PART 3" instantiates a "game" object
	through the WarManager class - essentially, the game class
	then, the methods which drive the game are called upon
	the game object in sequence (lines 25-27).
	"PART 1" and "PART 2" are basic, modular testing areas
	for the ArrDeck / ArrListDeck classes and the
	LinkStack / CardStack classes as well ~!! */

package GameOfWar;

//OUR MAIN CLASS
public class CardDeckTester {
	//MAIN METHOD HERE!!
	public static void main(String[] args) {
		//PART 3: 
		//WHERE WE PLAY THE GAME
		//NO TOUCHING UNLESS AUTHORIZED!!
		WarManager game = new WarManager();
		game.setup();
		game.deal();
		game.play();
		
		// ~ TESTING AREA / PARTS 1 AND 2 BELOW ~
		//PARTS 1 AND 2 TESTING AREA BELOW; BOTH ARRAY AND ARRAYLIST IMPLEMENTATIONS OF THE - 
		// - CARD DECK, AND TESTING OF THE LINKED STACK / CARD STACK CLASS AS WELL!! 
		
		
		// ---------------------------------------------------------------------------------------------
		
		
		//PART 1:
		// vv ARRAY DECK (COMMENT BLOCK FOR TEST CODE BEGINS ON LINE 39 DIRECTLY BELOW)! vv
		/*DeckInterface arrDeck = new ArrDeck();
		arrDeck.populate();
        System.out.println("There are " + arrDeck.deckSize() + " cards in the deck");
        System.out.println("Deck is being shuffled 25 times.");
        arrDeck.shuffleDeck(25);
        System.out.println(arrDeck.toString());
        System.out.println("Player 1 draws a card.");
        Card p1CardAD = arrDeck.drawCard();
        System.out.println("Player 1 drew the " + p1CardAD + ".");
        System.out.println("There are " + arrDeck.deckSize() + " cards in the deck.");
        System.out.println("Player 2 draws a card.");
        Card p2CardAD = arrDeck.drawCard();
        System.out.println("Player 2 drew the " + p2CardAD + ".");
        System.out.println("There are " + arrDeck.deckSize() + " cards in the deck.");
        System.out.println("The top card of the deck is the " + arrDeck.peek() + ".");
		
        System.out.printf("\n\n\n");
        
        //ARRAYLIST DECK (COMMENT BLOCK FOR PART 1 TEST CODE ENDS ON LINE 58 BELOW THIS ARRAYLIST TEST)!
        DeckInterface arrListDeck = new ArrListDeck();
		arrListDeck.populate();
        System.out.println("There are " + arrDeck.deckSize() + " cards in the deck");
        System.out.println("Deck is being shuffled 25 times.");
        arrListDeck.shuffleDeck(25);
        System.out.println(arrListDeck.toString());
        System.out.println("Player 1 draws a card.");
        Card p1CardAL = arrListDeck.drawCard();
        System.out.println("Player 1 drew the " + p1CardAL + ".");
        System.out.println("There are " + arrListDeck.deckSize() + " cards in the deck.");
        System.out.println("Player 2 draws a card.");
        Card p2CardAL = arrListDeck.drawCard();
        System.out.println("Player 2 drew the " + p2CardAL + ".");
        System.out.println("There are " + arrListDeck.deckSize() + " cards in the deck.");
        System.out.println("The top card of the deck is the " + arrListDeck.peek() + ".");*/
		// ^^ (COMMENT BLOCK FOR PART 1 TEST CODE ENDS ON LINE 54 DIRECTLY ABOVE)! ^^
		
		
		// ---------------------------------------------------------------------------------------------
		
		
		//PART 2:
		// vv LINKED STACK / CARD STACK (COMMENT BLOCK FOR PART 2 TEST CODE BEGINS ON LINE 81 DIRECTLY BELOW)! vv
		/*LinkStack<Card> cards = new CardStack<Card>();
        Card queenSpades = new Card("Spades", 12);
        Card tenDiamonds = new Card("Diamonds", 10);
        Card jackHearts = new Card("Hearts", 11);
        Card aceClubs = new Card("Clubs", 14);
        Card kingDiamonds = new Card("Diamonds", 13);
        cards.push(queenSpades);
        cards.push(tenDiamonds);
        cards.push(jackHearts);
        System.out.println("Card stack size is " + cards.size() + ".");
        System.out.println(cards.toString());
        System.out.println("Poptop performed. New top card is " + cards.poptop() + ".");
        System.out.println(cards.toString());
        System.out.println("Is the card stack empty?: " + cards.isEmpty());
        cards.pop();
        System.out.println("Pop performed.");
        System.out.println("Card stack size is " + cards.size() + ".");
        cards.push(aceClubs);
        cards.push(kingDiamonds);
        System.out.println("Two new cards pushed to stack.");
        System.out.println("Card stack size is " + cards.size() + ". Top card is " + cards.top());
        cards.clear();
        System.out.println("Card stack cleared.");
        System.out.println(cards.toString());
        System.out.println("Is the card stack empty?: " + cards.isEmpty());*/
		// ^^ (COMMENT BLOCK FOR PART 2 TEST CODE ENDS ON LINE 83 DIRECTLY ABOVE)! ^^
		
	}
}