package Board;

import java.util.ArrayList;
import java.util.Set;

public class ComputerPlayer extends Player {
	//uml based
	private char lastRoomVisited;
	
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

	public char getLastRoomVisited() {
		// TODO Auto-generated method stub
		return lastRoomVisited;
	}
}
