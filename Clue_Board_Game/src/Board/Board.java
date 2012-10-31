package Board;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//import tests.Arraylist;

import Board.RoomCell.DoorDirection;

public class Board {

	private ArrayList<BoardCell> cells = new ArrayList<BoardCell>();
	private Map<Character, String> rooms = null;
	private Map<BoardCell, LinkedList<Integer>> adjMtx;
	private Boolean[] visited;
	private Set<BoardCell> targets;
	private int numRows = 25;
	private int numColumns = 24;
	//rader test from previous group
	private String configOne = "Config1.txt";
	private String configTwo = "Config2.txt";
	//maria and anastasia's stuff
	private String ourlegend = "legend.txt";
	private String ourboard = "clueboard.csv";

	public Board() {
		super();
		adjMtx = new HashMap<BoardCell, LinkedList<Integer>>();
		targets = new HashSet<BoardCell>();
		loadConfigFiles();
		calcAdjacencies();
	}

	public RoomCell getRoomCellAt(int row, int column){
		return (RoomCell) cells.get(calcIndex(row, column));	
	}

	public BoardCell getCellAt(int start) {
		return cells.get(start);
	}

	public Set<BoardCell> getTargets(){
		return targets;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	public ArrayList<BoardCell> getCells() {
		return cells;
	}

	public Map<Character, String> getRooms() {
		return rooms;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public int calcIndex(int row, int column){
		return (row*numColumns+column);
	}

	public boolean doorwayWorks(int index, RoomCell.DoorDirection dd) {
		RoomCell rc = (RoomCell) cells.get(index);
		if(rc.isDoorway() && rc.getDoorDirection() == dd)
			return true;
		return false;
	}

	public void calcAdjacencies(){
		LinkedList<Integer> local;

		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numColumns; j++) {
				local = new LinkedList<Integer>();
				if(cells.get(calcIndex(i,j)).isRoom() && !cells.get(calcIndex(i,j)).isDoorway()) {
					adjMtx.put(cells.get(calcIndex(i,j)), local);
					continue;
				}
				//Make sure you exit room correctly
				if(cells.get(calcIndex(i,j)).isRoom() && cells.get(calcIndex(i,j)).isDoorway()) {
					RoomCell tempRoom = (RoomCell)cells.get(calcIndex(i,j));
					switch(tempRoom.getDoorDirection()){

					case UP : local.add(numColumns*(i-1)+j);
					adjMtx.put(cells.get(calcIndex(i, j)), local);
					continue;
					case DOWN : local.add(numColumns*(i+1)+j);
					adjMtx.put(cells.get(calcIndex(i, j)), local);
					continue;
					case LEFT : local.add(numColumns*(i)+(j-1));
					adjMtx.put(cells.get(calcIndex(i, j)), local);
					continue;
					case RIGHT : local.add(numColumns*(i)+(j+1));
					adjMtx.put(cells.get(calcIndex(i, j)), local);
					continue;
					case NONE:
					}
				}
				// Check above the cell
				if(i!=0) {
					if(cells.get(calcIndex(i-1,j)).isWalkway())
						local.add(numColumns*(i-1)+j);
					else if(doorwayWorks(calcIndex(i-1,j), RoomCell.DoorDirection.DOWN))
						local.add(numColumns*(i-1)+j);
				}
				// Check below the cell
				if (i!=numRows-1) {
					if(cells.get(calcIndex(i+1,j)).isWalkway()) 
						local.add(numColumns*(i+1) + j);
					else if(doorwayWorks(calcIndex(i+1,j), RoomCell.DoorDirection.UP))
						local.add(numColumns*(i+1) + j);
				}
				// Check left of the cell
				if(j!=0) {
					if(cells.get(calcIndex(i,j-1)).isWalkway())
						local.add(numColumns*i + j - 1);
					else if(doorwayWorks(calcIndex(i,j-1), RoomCell.DoorDirection.RIGHT))
						local.add(numColumns*i+j-1);
				}
				// Check right of the cell
				if (j!=numColumns-1) {
					if(cells.get(calcIndex(i,j+1)).isWalkway())
						local.add(numColumns*i + j + 1);
					else if(doorwayWorks(calcIndex(i,j+1), RoomCell.DoorDirection.LEFT))
						local.add(numColumns*i+j+1);
				}
				adjMtx.put(cells.get(calcIndex(i,j)), local);
			}
		}
	}

	public void recursiveTargets(int start, int steps) {
		int place;
		BoardCell cell = cells.get(start);
		visited[start] = true;
		if(steps == 0) {
			targets.add(cell);
			visited[start] = false;
			return;
		} else {
			LinkedList<Integer> adjacent = getAdjList(start);
			for(int i=0; i<adjacent.size(); i++) {
				place = adjacent.get(i);
				if(visited[place] == false) {
					if(cells.get(place).isDoorway())
						targets.add(cells.get(place));
					else
						recursiveTargets(place , steps-1);
				}
			}
		}
		visited[start] = false;
	}

	public void calcTargets(int start, int steps){
		targets = new HashSet<BoardCell>();
		recursiveTargets(start, steps);
	}
	public LinkedList<Integer> getAdjList(int cell){
		return adjMtx.get(cells.get(cell));
	}

	public void loadConfigFiles(){

		try{
			//FileReader reader = new FileReader(configOne);
			FileReader reader = new FileReader(ourlegend);
			Scanner in = new Scanner(reader);
			RoomCell r;
			WalkwayCell w;
			rooms = new HashMap<Character, String>();
			String input;
			int rowCount = 0;
			int totalCount = 0;
			String name;
			while(in.hasNext()){
				name = in.nextLine();
				char key = name.charAt(0);
				name = name.substring(3);
				rooms.put(key, name);
			}

			in.close();
			//reader = new FileReader(configTwo);
			reader = new FileReader(ourboard);
			in = new Scanner (reader);
			while(in.hasNextLine())
			{
				String line = in.nextLine();
				for(int i=0; i<line.length(); i++) {
					if(line.charAt(i) == ',')
						i++;
					r = new RoomCell();
					w = new WalkwayCell();
					int end;
					if(i >= line.length()-1) {
						end = i+1;
						input = line.substring(i, end);
					}
					else {
						if(line.charAt(i+1)!= ',') {
							end = i+2;
						}
						else
							end = i+1;
						input = line.substring(i, end);
					}
					r.setInitial(input.charAt(0));
					if(input.length() > 1)
					{
						if (input.charAt(1) == 'U')
							r.setDoorDirection(DoorDirection.UP);

						if (input.charAt(1) == 'D')
							r.setDoorDirection(DoorDirection.DOWN);

						if (input.charAt(1) == 'L')
							r.setDoorDirection(DoorDirection.LEFT);

						if (input.charAt(1) == 'R')
							r.setDoorDirection(DoorDirection.RIGHT);	
					}
					if (input.charAt(0) == 'W')
					{
						cells.add(w);
					}
					else
					{
						r.setInitial(input.charAt(0));
						cells.add(r);
					}
					totalCount++;
					if(end == i+2)
						i++;
				}
				rowCount++;
			}
			in.close();

			numRows = rowCount;
			numColumns = totalCount / rowCount; 
			visited = new Boolean [totalCount];
			for (int i=0; i<totalCount; i++)
				visited[i] = false;
			
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public boolean checkAccusation(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deal() {
		// TODO Auto-generated method stub
	}

	public ArrayList<Card> getDeck() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//counting the number of cards in the Cards.txt file
	

	/*public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board.calcIndex(0, 4));
	}*/

}