package Board;

public class Card {
	//uml based
	public enum CardType { ROOM, WEAPON, PERSON };
	
	public String name;
	public CardType cardtype;

	//getters
	public String getName() {
		return name;
	}

	public CardType getCardtype() {
		return cardtype;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setCardtype(CardType cardtype) {
		this.cardtype = cardtype;
	}

	
	
	
}
