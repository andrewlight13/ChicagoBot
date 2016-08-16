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
		players.get(0).printDieVals();
		players.get(0).cheat();
		players.get(0).printDieVals();
		System.out.println("------multisix-----");
		players.get(0).multiSix(3);
		//System.out.println("SCORE:");
		//System.out.println(players.get(0).getScore(true));
		//System.out.println(players.get(0).getScore(false));
		System.out.println("Is Special: " + p.isSpecial());
		players.get(0).endRoll();
		System.out.println("---------------");
		/*players.get(0).rollDice();
		players.get(0).printDieVals();
		players.get(0).selectDie(6);
		players.get(0).printDieVals();
		System.out.println("Is Special: " + p.isSpecial());
		System.out.println("MULTISIX TESTING:");
		players.get(0).multiSix(2);
		players.get(0).endRoll();
		System.out.println("---------------");
		players.get(0).rollDice();
		players.get(0).printDieVals();
		players.get(0).selectDie(6);
		players.get(0).printDieVals();
		System.out.println("Is Special: " + p.isSpecial());
		players.get(0).endRoll();
		System.out.println("---------------");*/
		
		
	}
}
