package Board;

import java.util.Set;

public class Player {
	//uml based
	private String name;

	private String color;
	
	private int initpos;
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getPosition(){
		return initpos;
	}

	public Card disproveSuggestions(String person, String room, String weapon){
		return null;
	}

	public BoardCell pickLocation(Set<BoardCell> targets) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
