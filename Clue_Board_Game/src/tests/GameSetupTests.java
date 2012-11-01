package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import Board.Board;
import Board.Card.CardType;
import Board.ComputerPlayer;
import Board.HumanPlayer;
import Board.Player;
import Board.Card;

public class GameSetupTests {
	//declaring objects
	public static Board board;
	public static ComputerPlayer mustard;
	public static ComputerPlayer scarlett;
	public static HumanPlayer human;
	public static Card card;
	
	//do this before anything else!
	@BeforeClass
	public void setUp(){
		//creating new  Board object
		board = new Board();
		//declaring new ComputerPlayers
		mustard = new ComputerPlayer("Colonel Mustard", "Yellow", board.calcIndex(0,4));
		scarlett = new ComputerPlayer("Miss Scarlett", "Red", board.calcIndex(20, 3));
		//declaring new HumanPlayer object
		human = new HumanPlayer("Mrs. Peacock", "Blue", board.calcIndex(16, 19));
	}
	
	//test loading people from file
	@Test
	public void testLoadFromFile() {
		//Colonel Mustard - computer
		Player mustardTest = board.getPlayers().get(0);
		assertEquals(mustard.getName(), mustardTest.getName());
		assertEquals(mustard.getColor(), mustardTest.getColor());
		assertEquals(board.calcIndex(0,4), mustardTest.getPosition());
		
		//Miss Scarlett - computer
		Player scarlettTest = board.getPlayers().get(5);
		assertEquals(scarlett.getName(), scarlettTest.getName());
		assertEquals(scarlett.getColor(), scarlettTest.getColor());
		assertEquals(board.calcIndex(20,3), scarlettTest.getPosition());
		
		//Mrs. Peacock - testing human player
		Player peacockTest = board.getPlayers().get(3);
		assertEquals(human.getName(), peacockTest.getName());
		assertEquals(human.getColor(), peacockTest.getColor());
		assertEquals(board.calcIndex(16,19), peacockTest.getPosition());
	}

	//test loading the cards from files
	@Test
	public void testLoadCardsFromFile() {
		
		//our deck of cards
		ArrayList<Card> deck = board.getDeck();
		
		int numRooms = 0;
		int numWeapons = 0;
		int numSuspects = 0;
		int totalCards = deck.size();
		
		//correct number of total cards
		Assert.assertEquals(21, totalCards);
		
		for (int i=0; i<totalCards; i++) {
			CardType cardtype = deck.get(i).getCardtype();
			if (cardtype == CardType.ROOM)
				numRooms++;
			else if (cardtype == CardType.WEAPON)
				numWeapons++;
			else
				numSuspects++;
		}
		
		//correct number of each type of card
		Assert.assertEquals(6, numWeapons);
		Assert.assertEquals(6, numSuspects);
		Assert.assertEquals(9, numRooms);
		
		//testing one of each card
		card = new Card("Reverend Green", CardType.PERSON);
		Assert.assertTrue(deck.contains(card.getName()));
		
		card = new Card("Lead Pipe", CardType.WEAPON);
		Assert.assertTrue(deck.contains(card.getName()));
		
		card = new Card("Marquez", CardType.ROOM);
		Assert.assertTrue(deck.contains(card.getName()));
	}
	
	//testing the deal (ugly baby ahead)
	//NEED BETTER WAY TO DO THIS
	@Test
	public void testDeal(){
		//creating Players
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();
		Player player5 = new Player();
		Player player6 = new Player();
		
		board.deal();
		
		//dealt cards for each player
		ArrayList<Card> dealtcards1 = player1.getCards();
		ArrayList<Card> dealtcards2 = player2.getCards();
		ArrayList<Card> dealtcards3 = player3.getCards();
		ArrayList<Card> dealtcards4 = player4.getCards();
		ArrayList<Card> dealtcards5 = player5.getCards();
		ArrayList<Card> dealtcards6 = player6.getCards();
		
		int totalCards = dealtcards1.size() + dealtcards2.size() + dealtcards3.size() + dealtcards4.size() + dealtcards5.size() + dealtcards6.size();
		
		//18 cards dealt among players, 3 are the solution
		Assert.assertEquals(18, totalCards);
		
		//making sure that each person has three cards
		Assert.assertEquals(3, dealtcards1.size());
		Assert.assertEquals(3, dealtcards2.size());
		Assert.assertEquals(3, dealtcards3.size());
		Assert.assertEquals(3, dealtcards4.size());
		Assert.assertEquals(3, dealtcards5.size());
		Assert.assertEquals(3, dealtcards6.size());
		
		//make sure that each card is unique to the player
		Card revolverCard = new Card("Revolver", CardType.WEAPON);
		Card aldersonCard = new Card("Alderson", CardType.ROOM);
		Card mustardCard = new Card("Colonel Mustard", CardType.PERSON);
		Card plumCard = new Card("Professor Plum", CardType.PERSON);
		
		int revolver = 0;
		int alderson = 0;
		int mustard = 0;
		int plum = 0;
		
		for (int j=0; j<3; j++) {
			Card card1 = dealtcards1.get(j);
			Card card2 = dealtcards2.get(j);
			Card card3 = dealtcards3.get(j);
			Card card4 = dealtcards4.get(j);
			Card card5 = dealtcards5.get(j);
			Card card6 = dealtcards6.get(j);
			if (card1 == revolverCard || card2 == revolverCard || card3 == revolverCard || card4 == revolverCard || card5 == revolverCard || card6 == revolverCard)
				revolver++;
			if (card1 == aldersonCard || card2 == aldersonCard || card3 == aldersonCard || card4 == aldersonCard || card5 == aldersonCard || card6 == aldersonCard)
				alderson++;
			if (card1 == mustardCard || card2 == mustardCard || card3 == mustardCard || card4 == mustardCard || card5 == mustardCard || card6 == mustardCard)
				mustard++;
			if (card1 == plumCard || card2 == plumCard || card3 == plumCard || card4 == plumCard || card5 == plumCard || card6 == plumCard)
				plum++;
		}
		assertEquals(1, revolver);
		assertEquals(1, alderson);
		assertEquals(1, mustard);
		assertEquals(1, plum);
	}
}
