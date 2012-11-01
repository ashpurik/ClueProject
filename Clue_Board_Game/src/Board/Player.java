package Board;

import java.util.ArrayList;
import java.util.Set;

import Board.Card;

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

	public BoardCell pickLocation(Set<BoardCell> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCards(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		
	}

	public Card disproveSuggestion(String string, String string2, String string3) {
		return null;
		
	}

	public ArrayList<Card> getCards() {
		return null;
	}


	
}
