package tests;

import static org.junit.Assert.*;

import javax.smartcardio.Card;

import org.junit.BeforeClass;
import org.junit.Test;

import Board.Board;
import Board.ComputerPlayer;
import Board.HumanPlayer;
import Board.Player;

public class GameActionsTest {
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
