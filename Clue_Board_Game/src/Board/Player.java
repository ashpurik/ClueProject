package Board;

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
	
}
