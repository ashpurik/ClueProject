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
	ArrayList<String> seen = new ArrayList<String>();
	
	public ComputerPlayer() {
		super();
	}
	
	public ComputerPlayer(String name, String color, int initpos) {
		this.name = name;
		this.color = color;
		this.initpos = initpos;
		//seen.add(new Card(name, CardType.PERSON));
		seen.add(name);
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
		
		//the computer suggestion has no choice but to choose the room it is currently in
		if (roomsugg.isRoom()) {
			String cardname = board.findMapValue(((RoomCell) roomsugg).getInitial());
			Card card = new Card(cardname, CardType.ROOM);
			suggcomp.add(card);
			
			//Making sure that the room that is put in Board is the right room
			//System.out.println("Room Name:");
			//System.out.println(card.getName() + " \n");
		}
		
	
		//while (suggcomp.size() != 3) {
			for (int i=0; i<board.getDeck().size(); i++) {
				Card eachCard = board.getDeck().get(i);
					if (!seen.contains(eachCard.getName())) {
						//System.out.println(eachCard.getName());
						if (eachCard.getCardtype() == CardType.PERSON) {
							suggcards.add(eachCard);
							//break;
						}
						if (eachCard.getCardtype() == CardType.WEAPON) {
							suggcards.add(eachCard);
							//break;
						}
					}
				
			}
		//}
		/*for (int i=0; i<suggcomp.size(); i++) {
			System.out.println(suggcomp.get(i).getName());
		}*/
			
			Collections.shuffle(suggcards);
			
			//picking possible person or weapon for the suggestion
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
		
		//int count=0;
		//adding all people and weapons it has not seen
		//go through whatever has not been seen for person and weapon card suggestions
		
		/*for (int i=0; i<seen.size(); i++) {
			for (int j=0; j<board.getDeck().size(); j++) {
				if (seen.contains)
				/*if(!seen.get(i).getName().equals(board.getDeck().get(j).getName())) {
					System.out.println(count + " " + board.getDeck().get(j).getName());
				} else {
					//System.out.println(count + " " + board.getDeck().get(j).getName());
					System.out.println(count + " not in deck");
				}
				
				count ++;
			}
			
		}*/
		
		/*for (int i=0;i< board.getDeck().size();i++) {
			//if the card has not been seen
			//System.out.println(count + board.getDeck().get(i).getName());
			//if (!seen.contains(board.getDeck().get(i))) {
				//if it's a person add to the suggestion
				//System.out.println(count + "in if");
			//} 
			count++;
				/*if(board.getDeck().get(i).getCardtype() == CardType.PERSON) {
					suggcards.add(board.getDeck().get(i));
				}
				//if it's a weapon add to the suggestion
				if(board.getDeck().get(i).getCardtype() == CardType.WEAPON) {
					suggcards.add(board.getDeck().get(i));
				}
			}
			
			System.out.println(suggcards.get(i).getName());
		}*/
			
			for (int i=0; i<suggcomp.size(); i++) {
				System.out.println(suggcomp.get(i).getName());
			}
			
		return suggcomp;
		
/*
		
		Collections.shuffle(suggcards);
		
		//picking possible person or weapon for the suggestion
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
		System.out.println("Suggcomp:");
		for(int i=0; i < suggcomp.size(); i++){
				System.out.println(suggcomp.get(i).getName());
		}
	
	return suggcomp;	*/
}
	
	public void updateSeen(String seencard){
		seen.add(seencard);
	}
	
	/*public ArrayList<Card> getSeen() {
		return seen;
	}*/

	public char getLastRoomVisited() {
		return lastRoomVisited;
	}
	
	public void setLastRoomVisited(char rm) {
		lastRoomVisited = rm;
	}
	
	public static void main(String[] args) {
		//Board board = new Board();
		BoardCell room = new RoomCell();
		((RoomCell) room).setInitial('G');
		ComputerPlayer player = new ComputerPlayer("Mrs. White", "White", 15);
		player.updateSeen("Colonel Mustard");
		player.updateSeen("Stratton");
		player.updateSeen("Miss Scarlett");
		System.out.println(player.createSuggestion(room));
	}
		

}
