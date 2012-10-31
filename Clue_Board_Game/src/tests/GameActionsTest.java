package tests;

import static org.junit.Assert.*;

import javax.smartcardio.Card;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import Board.Board;
import Board.BoardCell;
import Board.ComputerPlayer;
import Board.HumanPlayer;
import Board.Player;
import Board.RoomCell;
import Board.Solution;

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
			Solution solution = new Solution("Professor Plum", "Berthoud", "Candlestick");
			//tests correct accusation
			Assert.assertTrue(board.checkAccusation("Professor Plum", "Berthoud", "Candlestick"));
			//tests incorrect name accusation
			Assert.assertFalse(board.checkAccusation("Miss Scarlett", "Berthoud", "Candlestick"));
			//tests incorrect room accusation
			Assert.assertFalse(board.checkAccusation("Professor Plum", "Library", "Candlestick"));
			//tests incorrect weapon accusation
			Assert.assertFalse(board.checkAccusation("Professor Plum", "Berthoud", "Dagger"));
			//tests if all three are wrong
			Assert.assertFalse(board.checkAccusation("Miss Scarlett", "Guggenheim", "Lead Pipe"));
		}
		
		//test selecting a target location
		@Test
		public void testTargetRoomPreference() {
			comp = new ComputerPlayer();
			
			//if room is last visited, random choice is made
			board.calcTargets(board.calcIndex(0,7), 4);
			BoardCell choice = player.pickLocation(board.getTargets());
			RoomCell room = board.getRoomCellAt(2,6);
			for(int i=0; i<25; i++) {
				if (room.getInitial() == comp.getLastRoomVisited())
					Assert.assertFalse(choice.isRoom());
				Assert.assertTrue(choice.isWalkway());
			}
			
			//ensures that room is always selected if it isn't last visited		
			choice = player.pickLocation(board.getTargets());
			for(int i=0; i<25; i++) {
				if (room.getInitial() != comp.getLastRoomVisited())
					Assert.assertEquals(board.getCellAt(board.calcIndex(21, 5)), choice);
					Assert.assertEquals(board.getCellAt(board.calcIndex(19,3)), choice);
			}
						
		}
		
		@Test
		public void testTargetRandomSelection() {
			ComputerPlayer player = new ComputerPlayer();
			// Pick a location with no rooms in target, just three targets
			board.calcTargets(board.calcIndex(14, 0), 2);
			int loc_12_0Tot = 0;
			int loc_14_2Tot = 0;
			int loc_15_1Tot = 0;
			// Run the test 100 times
			for (int i=0; i<100; i++) {
				BoardCell selected = player.pickLocation(board.getTargets());
				if (selected == board.getCellAt(board.calcIndex(12, 0)))
					loc_12_0Tot++;
				else if (selected == board.getCellAt(board.calcIndex(14, 2)))
					loc_14_2Tot++;
				else if (selected == board.getCellAt(board.calcIndex(15, 1)))
					loc_15_1Tot++;
				else
					fail("Invalid target selected");
			}
			// Ensure we have 100 total selections (fail should also ensure)
			assertEquals(100, loc_12_0Tot + loc_14_2Tot + loc_15_1Tot);
			// Ensure each target was selected more than once
			assertTrue(loc_12_0Tot > 10);
			assertTrue(loc_14_2Tot > 10);
			assertTrue(loc_15_1Tot > 10);							
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
