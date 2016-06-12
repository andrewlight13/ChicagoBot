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
		System.out.println(p.isSpecial());
		System.out.println("---------------");
		players.get(0).rollDice();
		players.get(0).printDieVals();
		System.out.println(p.isSpecial());
		System.out.println("---------------");
		players.get(0).rollDice(Reroll.IOO);
		players.get(0).printDieVals();
		System.out.println(p.isSpecial());
		System.out.println("---------------");
		players.get(0).rollDice(Reroll.OII);
		players.get(0).printDieVals();
		
		System.out.println(p.isSpecial());
		
	}
}
