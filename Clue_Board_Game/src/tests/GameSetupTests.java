package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import Board.Board;
import Board.ComputerPlayer;
import Board.HumanPlayer;

public class GameSetupTests {
	//declaring objects
	public static Board board;
	public static ComputerPlayer comp;
	public static HumanPlayer human;
	
	
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
		Assert.assertEquals(9,  numRooms);
		
		
				
	}
	
	//testing the deal
	@Test
	public void testDeal(){
		
	}
	
	//test making an accusation
	@Test
	public void testMakeAnAccusation() {
		
	}
	
	//test selecting a target location
	@Test
	public void testSelectTargetLocation() {
		
	}
	
	//test disproving a suggestions
	@Test
	public void testDisproveSuggestion(){
		
	}
	
	//test computer player making a suggestion
	@Test
	public void testComputerSuggestion(){
		
	}
}
