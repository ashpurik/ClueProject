package Board;

import java.util.ArrayList;
import java.util.Set;

import Board.Card;

public class Player {
	//uml based
	protected String name;
	protected String color;
	protected int initpos;
	
	public Player() {
	}
	
	public Player(String name, String color, int initpos) {
		this.name = name;
		this.color = color;
		this.initpos = initpos;
	}
	
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

	public Card disproveSuggestion(String person, String weapon, String room) {
		return null;
	}

	public ArrayList<Card> getCards() {
		return null;
	}


	
}
