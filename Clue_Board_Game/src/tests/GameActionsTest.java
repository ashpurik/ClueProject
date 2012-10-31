package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		public static Card mustardCard;
		public static Card scarlettCard;
		public static Card knifeCard;
		public static Card wrenchCard;
		public static Card greenCard;
		public static Card aldersonCard;
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
			mustardCard = new Card("Colonel Mustard", Card.CardType.PERSON);
			scarlettCard = new Card("Miss Scarlett", Card.CardType.PERSON);
			knifeCard = new Card("Knife", Card.CardType.WEAPON);
			wrenchCard = new Card("Wrench", Card.CardType.WEAPON);
			greenCard = new Card("Green Center", Card.CardType.ROOM);
			aldersonCard = new Card("Alderson", Card.CardType.ROOM);
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
			///if player has suggested card, that card is returned
			//if player has multiple cards that match, card to be show is randomly chosen
			//once player shows card, no other players queried
			//querying players will happen from random starting point
			//if no players have relevant cards, null is returned
			
			//create player with 6 cards
			ArrayList<Card> cards = new ArrayList<Card>();
			cards.add(mustardCard);
			cards.add(scarlettCard);
			cards.add(knifeCard);
			cards.add(wrenchCard);
			cards.add(greenCard);
			cards.add(aldersonCard);
			Player testPlayer = new Player();
			testPlayer.setCards(cards);
			
			//Test for one player, one correct match
			//Case 1: correct person returned
			Card test = testPlayer.disproveSuggestion("Colonel Mustard", "Marquez", "Dagger");
			Assert.assertEquals("Colonel Mustard", test.getName());
			//Case 2: correct weapon returned
			test = testPlayer.disproveSuggestion("Professor Plum", "Marquez", "Knife");
			Assert.assertEquals("Knife", test.getName());
			//Case 3: correct room returned
			test = testPlayer.disproveSuggestion("Professor Plum", "Alderson", "Dagger");
			Assert.assertEquals("Alderson", test.getName());
			//Case 4: null returned
			test = testPlayer.disproveSuggestion("Professor Plum", "Marquez", "Dagger");
			Assert.assertEquals(null, test.getName());
			
			//Test for one player, multiple possible matches
			int colonel = 0;
			int wrench = 0;
			int alderson = 0;
			int green = 0;
			for (int i=0; i<25; i++) {
				test = testPlayer.disproveSuggestion("Colonel Mustard", "Wrench", "Alderson");
				if (test.getName().equals("Colonel Mustard"))
					colonel++;
				if (test.getName().equals("Wrench"))
					wrench++;
				if (test.getName().equals("Alderson"))
					alderson++;
				if (test.getName().equals("Green Center"))
					green++;
			}
			assertTrue(colonel > 0);
			assertTrue(wrench > 0);
			assertTrue(alderson > 0);
			assertTrue(green == 0);
			
			//Test that all players are queried
			
			
		}
		
		//test computer player making a suggestion
		@Test
		public void testComputerSuggestion(){
			
		}

}
