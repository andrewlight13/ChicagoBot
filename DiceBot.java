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
		players.add(p);
		p.rollDice();
		players.get(0).printDieVals();
		players.get(0).selectDie(6);
		players.get(0).endTurn(true);
		System.out.println("SCORE:");
		System.out.println(players.get(0).score);
		

		
		
	}
}
