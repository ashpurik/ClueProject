package Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
		List<BoardCell> list = new ArrayList<BoardCell>(targets);
		for (BoardCell spot: targets) {
			if (spot.isDoorway() && ((RoomCell) spot).getInitial() != lastRoomVisited) {
				return spot;
			} else if (spot.isDoorway() && ((RoomCell) spot).getInitial() == lastRoomVisited) {
				int i= list.indexOf(spot);
				list.remove(i);
				Collections.shuffle(list);
				return list.get(0);
			}
		}
		Collections.shuffle(list);
		return list.get(0);
	}
	
	public ArrayList<Card> createSuggestion(BoardCell roomsugg){
		return null;
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
	
	/*public static void main(String[] args) {
		Board board = new Board();
		board.calcTargets(board.calcIndex(0,6), 2);
		
		ComputerPlayer comp = new ComputerPlayer();
		comp.setLastRoomVisited('G');
		for (int i=0; i<40; i++) {
			BoardCell choice = comp.pickLocation(board.getTargets());
			System.out.println(choice);
		}

	}*/
}
