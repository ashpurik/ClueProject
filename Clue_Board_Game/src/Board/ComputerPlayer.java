package Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import Board.Card.CardType;

public class ComputerPlayer extends Player {
	//uml based
	private char lastRoomVisited;
	ArrayList<Card> seen = new ArrayList<Card>();
	
	public ComputerPlayer() {
		super();
	}
	
	public ComputerPlayer(String name, String color, int initpos) {
		this.name = name;
		this.color = color;
		this.initpos = initpos;
	}

	public BoardCell pickLocation(Set<BoardCell> targets){
		List<BoardCell> list = new ArrayList<BoardCell>(targets);
		
		for (BoardCell spot: targets) {
			//if you can go into that room and you haven't been in that room you must go in
			if (spot.isDoorway() && ((RoomCell) spot).getInitial() != lastRoomVisited) {
				return spot;
			//if you have visited you don't want to go in
			} else if (spot.isDoorway() && ((RoomCell) spot).getInitial() == lastRoomVisited) {
				//grab the spot of the room
				int i= list.indexOf(spot);
				list.remove(i);
				Collections.shuffle(list);
				//return the first random spot , must be walkway
				return list.get(0);
			}
		}
		//assuming that a room is not an option, just shuffle the list and pick the first one
		Collections.shuffle(list);
		return list.get(0);
	}
	
	public ArrayList<Card> createSuggestion(BoardCell roomsugg){
		//make a suggestion based on what is seen
		//creating a new board
		Board board = new Board();
	
		//Array list of cards that can be returned
		ArrayList<Card> suggcards = new ArrayList<Card>();
		ArrayList<Card> suggcomp = new ArrayList<Card>();
		
	
		//adding all people and weapons it has not seen
		//go through whatever has not been seen for person and weapon card suggestions
		for (int i=0;i< board.getDeck().size();i++) {
			//if the card has not been seen
			if (!seen.contains(board.getDeck().get(i))) {
				//if it's a person add to the suggestion
				if(board.getDeck().get(i).getCardtype() == CardType.PERSON) {
					suggcards.add(board.getDeck().get(i));
				}
				//if it's a weapon add to the suggestion
				if(board.getDeck().get(i).getCardtype() == CardType.WEAPON) {
					suggcards.add(board.getDeck().get(i));
				}
			}
		}
		
		//the computer suggestion has no choice but to choose the room it is currently in
		if (roomsugg.isRoom()) {
			String cardname = board.findMapValue(((RoomCell) roomsugg).getInitial());
			Card card = new Card(cardname, CardType.ROOM);
			suggcomp.add(card);
		}
		
		Collections.shuffle(suggcards);
		
		//picking only person for the suggestion
		for (int i=0; i < suggcards.size(); i++) {
			if(suggcards.get(i).getCardtype() == CardType.PERSON) {
				suggcomp.add(suggcards.get(i));
			}
			if(suggcards.get(i).getCardtype() == CardType.WEAPON) {
				suggcomp.add(suggcards.get(i));
			}
			if(suggcomp.size() == 3) {
				break;
			}
		}
		
		//Attempting to find out what is being put into suggcomp
		for(int i=0; i < suggcomp.size(); i++){
			System.out.println(i + " " + suggcomp.get(i).getName());
		}
		
		
		/* decided that perhaps the order doesn't matter
		System.out.println("Attempted Suggestion:");
		System.out.println("Person: " + suggcomp.get(0).getName() + " Weapon: " + suggcomp.get(1).getName() + " Room: " + suggcomp.get(2).getName());
		*.
		*/
		
		return suggcomp;
		
	}
	
	public void updateSeen(Card seencard){
		seen.add(seencard);
	}
	
	public ArrayList<Card> getSeen() {
		return seen;
	}

	public char getLastRoomVisited() {
		return lastRoomVisited;
	}
	
	public void setLastRoomVisited(char rm) {
		lastRoomVisited = rm;
	}

}
