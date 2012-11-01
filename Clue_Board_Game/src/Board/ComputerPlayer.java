package Board;

import java.util.ArrayList;
import java.util.Set;

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
		return null;
	}
	
	public ArrayList<Card> createSuggestion(BoardCell roomsugg){
		return null;
	}
	
	public void updateSeen(Card seen){
		
	}
	
	public ArrayList<Card> getSeen() {
		return seen;
	}

	public char getLastRoomVisited() {
		// TODO Auto-generated method stub
		return lastRoomVisited;
	}
}
