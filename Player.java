package projectdicecord;

import java.util.*;

public class Player {
	private int lives;	//add getter/setter/dedicated decrement function
	private int[] lastRoll;	//maybe make this an ordered list
	Player(){
		lastRoll = new int[3];
		lives = 3;
	}
	
	public void rollDice() {
		Random r = new Random();
		lastRoll[0] = r.nextInt(6) + 1;		//random int from 0-5, plus 1 to get 0-6
		lastRoll[1] = r.nextInt(6) + 1;
		lastRoll[2] = r.nextInt(6) + 1;
	} 
	public void rollDice(Reroll die) {			//this will be for re-rolling, not sure what we should do for parameters just yet
		Random r = new Random();
		switch  (die){
			case OOO:
				break;
			case OOI:
				lastRoll[2] = r.nextInt(6) + 1;
				break;
			case OIO:
				lastRoll[1] = r.nextInt(6) + 1;
				break;
			case OII:
				lastRoll[1] = r.nextInt(6) + 1;
				lastRoll[2] = r.nextInt(6) + 1;
				break;
			case IOO:
				lastRoll[0] = r.nextInt(6) + 1;
				break;
			case IOI:
				lastRoll[0] = r.nextInt(6) + 1;
				lastRoll[2] = r.nextInt(6) + 1;
				break;
			case III:
				lastRoll[0] = r.nextInt(6) + 1;
				lastRoll[1] = r.nextInt(6) + 1;
				lastRoll[2] = r.nextInt(6) + 1;
				break;
		}
	} 
	private int isSpecial() {				//checks current contents of lastRoll, should be run every time you roll, 0 = not special, 1 = pair of 6, 2 = "165" 3 = chicago
		return 0;	//NO ONE IS SPECIAL (implement this lol)
	} 	
	public int getScore(boolean isHigh) {		//get round score
		if(isSpecial() > 0){		//also need to check isHigh obviously
			return 1;
		}
		return 0;
	}	
	public void printDieVals() {
		System.out.println("Die 1 = " + lastRoll[0]);
		System.out.println("Die 2 = " + lastRoll[1]);
		System.out.println("Die 3 = " + lastRoll[2]);
	}
}

enum Reroll{		//should probably put this in its own file, but doesn't matter too much lol
	OOO, OOI, OIO, OII, IOO, IOI, III
}
