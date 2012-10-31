package tests;

import static org.junit.Assert.*;

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
	
	//making sure that we are loading correct players from file
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

}
