package Board;

import java.util.ArrayList;
import java.util.Set;

public class ComputerPlayer extends Player {
	//uml based
	private char lastRoomVisited;
	ArrayList<Card> seen = new ArrayList<Card>();
	
	public ComputerPlayer() {
		// TODO Auto-generated constructor stub
	}
	
	public ComputerPlayer(String string, String string2, int calcIndex) {
		// TODO Auto-generated constructor stub
	}

	public BoardCell pickLocation(Set<BoardCell> targets){
		return null;
	}
	
	public ArrayList<Card> createSuggestion(){
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
