package tests;

import static org.junit.Assert.*;
import java.util.LinkedList;
//import javax.smartcardio.Card;
import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import Board.Board;
import Board.ComputerPlayer;
import Board.HumanPlayer;
import Board.Player;
import Board.Card;

public class GameSetupTests {
	//declaring objects
	public static Board board;
	public static ComputerPlayer comp;
	public static HumanPlayer human;
	public static Card card;
	public static Player player;
	
	
	//do this before anything else!
	@BeforeClass
	public void setUp(){
		//declaring new ComputerPlayer object
		comp = new ComputerPlayer();
		//declaring new HumanPlayer object
		human = new HumanPlayer();
		//creating new  Board object
		board = new Board();
	}
	
	//test loading people from file
	@Test
	public void testLoadFromFile() {
		//Colonel Mustard - computer
		assertEquals("Colonel Mustard", comp.getName());
		assertEquals("Yellow", comp.getColor());
		assertEquals(board.calcIndex(0,4), comp.getPosition());
		
		//Miss Scarlett - computer
		assertEquals("Miss Scarlett", comp.getName());
		assertEquals("Red", comp.getColor());
		assertEquals(board.calcIndex(20,3), comp.getPosition());
		
		//Mrs.Peacock - testing human player
		assertEquals("Mrs. Peacock", human.getName());
		assertEquals("Blue", human.getColor());
		assertEquals(board.calcIndex(16,19), human.getPosition());
	}

	
	//test loading the cards from files
	@Test
	public void testLoadCardsFromFile() {
		
		//our deck of cards
		LinkedList<Card> deck = board.getDeck();
		
		int numRooms = 0;
		int numWeapons = 0;
		int numSuspects = 0;
		int totalCards = board.getDeckSize();
		
		//correct number of cards
		Assert.assertEquals(21, totalCards);
		
		for (int i=0; i<totalCards; i++) {
			CardType cardtype = board.getCardat(i);
			if (cardtype == CardType.ROOM)
				numRooms++;
			else if (cardtype == CardType.WEAPON)
				numWeapons++;
			else
				numSuspects++;
		}
		
		//correct number of each cardtype
		Assert.assertEquals(6, numWeapons);
		Assert.assertEquals(6, numSuspects);
		Assert.assertEquals(9, numRooms);
		
		//testing one of each card
		card = new Card("Reverend Green");
		Assert.assertTrue(deck.contains(suspect));
		
		card = new Card("Lead Pipe");
		Assert.assertTrue(deck.contains(weapon));
		
		card = new Card("Marquez");
		Assert.assertTrue(deck.contains(room));
		
		
	}
	
	//testing the deal (ugly baby ahead)
	@Test
	public void testDeal(){
		//creating Players
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		player4 = new Player();
		player5 = new Player();
		player6 = new Player();
		
		//dealt cards for each player
		LinkedList<Card> dealtcards1 = player1.getCards();
		LinkedList<Card> dealtcards2 = player2.getCards();
		LinkedList<Card> dealtcards3 = player3.getCards();
		LinkedList<Card> dealtcards4 = player4.getCards();
		LinkedList<Card> dealtcards5 = player5.getCards();
		LinkedList<Card> dealtcards6 = player6.getCards();
		
		int totalCards = dealtcards1.size() + dealtcards2.size() + dealtcards3.size() + dealtcards4.size() + dealtcards5.size() + dealtcards6.size();
		
		//only 18 because 3 of the cards are in the mystery deck!
		Assert.assertEquals(18, totalCards);
		
		//making sure that each person has three cards
		Assert.assertEquals(3, dealtcards1.size());
		Assert.assertEquals(3, dealtcards2.size());
		Assert.assertEquals(3, dealtcards3.size());
		Assert.assertEquals(3, dealtcards4.size());
		Assert.assertEquals(3, dealtcards5.size());
		Assert.assertEquals(3, dealtcards6.size());
		
		//make sure that each card is unique to the player
		//pick a few cards, then iterate through all people's cards
		//count number of times each card comes up
		//should only come up once (otherwise there are duplicates)
		
	}
	
	
}
