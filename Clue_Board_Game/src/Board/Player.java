package Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import junit.framework.Assert;

import Board.Card;

public class Player {
	//uml based
	protected String name;
	protected String color;
	protected int initpos;
	ArrayList<Card> cards;
	
	public Player() {}
	
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

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public Card disproveSuggestion(String person, String weapon, String room) {
		ArrayList<Card> hasCards = new ArrayList<Card>();
		for (int i=0; i<cards.size(); i++) {
			if (cards.get(i).getName().equals(person)) {
				hasCards.add(cards.get(i));
			} else if (cards.get(i).getName().equals(weapon)) {
				hasCards.add(cards.get(i));
			} else if (cards.get(i).getName().equals(room)) {
				hasCards.add(cards.get(i));
			} 
		}
		if (hasCards.size() != 0) {
			Collections.shuffle(hasCards);
			return hasCards.get(0);
		} else {
			return null;	
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	/*public static void main(String[] args) {
		Board board = new Board();
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("Colonel Mustard", Card.CardType.PERSON));
		cards.add(new Card("Wrench", Card.CardType.WEAPON));
		cards.add(new Card("Alderson", Card.CardType.ROOM));
		Player testPlayer = new Player();
		testPlayer.setCards(cards);
		
		ArrayList<Card> pcards3 = new ArrayList<Card>();
		pcards3.add(new Card("Stratton", Card.CardType.ROOM));
		pcards3.add(new Card("Pipe", Card.CardType.WEAPON));
		pcards3.add(new Card("Chauvenet", Card.CardType.ROOM));
		Player p3 = new HumanPlayer();
		p3.setCards(pcards3);
		
		ArrayList<Player> playa = new ArrayList<Player>();
		playa.add(testPlayer);
		playa.add(p3);

		int humangift = 0;
		int bad=0;
		for( int i = 0; i < playa.size(); i++) {
			Card test2  = playa.get(i).disproveSuggestion("Mrs.Peacock", "Pipe", "Marquez");
			if (test2 != null && test2.getName().equals("Pipe"))
				System.out.println(test2);
			//if (test2.getName() == "Pipe") {
				//System.out.println("in if");
			//}
		}
		//System.out.println(humangift);
		//System.out.println(bad);
		
	}*/
	
}
