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
	public int isSpecial() {				
		//checks current contents of lastRoll, should be run every time you roll, 
		//0 = not special, 1 = pair of 6, 2 = triple of 6, 3 = "165" , 4 = chicago,
		
		boolean[] is165 = {true, true, true};
		int is165_c = 0;
		int isMulti6_c = 0;
		int isChicago_c = 0;
				
		for(int i: lastRoll)
		{				
			if(i == 1)
			{
				isChicago_c++;
				if(is165[0] == true)
				{
					is165[0] = false;
					is165_c++;
				}
			}
			if(i == 6)
			{
				isMulti6_c++;
				if(is165[1] == true)
				{
					is165[1] = false;
					is165_c++;
				}
			}
			if(i == 5 && is165[2] == true)
			{
				is165[2] = false;
				is165_c++;
			}				
		}
		
		if(isChicago_c == 3) return 4;
		if(is165_c == 3) return 3;
		if(isMulti6_c == 3) return 2;
		if(isMulti6_c == 2) return 1;
		
		return 0;	//NO ONE IS SPECIAL (implement this lol)
	} 	
	public int getScore(boolean isHigh) 
	{	//get round score
		//also need to check isHigh obviously
		int sum = 0;
		if(isSpecial() > 2)
		{		
			return -1;
		}
		if(isHigh == true)
		{
			for(int i: lastRoll)
			{
				if(i == 1) sum += 100;
				else if(i == 6) sum += 60;
				else sum += i;
			}
			return sum;
		}
		else
		{
			for(int i: lastRoll)
				sum += i;
			return sum;
		}
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
