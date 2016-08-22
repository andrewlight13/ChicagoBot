package projectdicecord;

import java.util.*;

public class DiceBot {
	boolean isHigh;
	int playerTurn;
	int numPlayers;
	static ArrayList<Player> players;
	Player curPlayer;
	public static void main(String []args) {
		players = new ArrayList<Player>();
		Player p = new Player();
		p.printFormattedDie(1, 2, 3);
		p.printFormattedDie(4, 5, 6);
		players.add(p);
		p.rollDice();
		players.get(0).printDieVals();
		players.get(0).selectDie(6);
		players.get(0).endTurn(true);
		System.out.println("SCORE:");
		System.out.println(players.get(0).score);		
		
	}
	public void gameOutput(String message){	//ezpz for now
		System.out.println(message);
	}
	public String inputChecker(String expected){	//in here, will check the input for what sort of command it is, against type "expected" (expected probably changed to enum or some shit like that)
															//if expected command, returns true (or we could change this to just returning the input maybe)
															//if not expected command, AND is valid alt command (quit etc.) then return false and handle that in other input parsers
															//if not expected command, AND isn't recognized either, or unauthorized user, etc. return false or error state or w/e
		
		return "todo";
	}
	public int getSelectedDie(){	//expects a string returned from inputChecker
		String input = inputChecker("selected");	//i'm thinking *not* doing strings for input checker after this lol
		//then you parse "input" into an int
		//then return that int into main, where it's needed
		return 0;
	}
	// and then, a few more similar to this
}
