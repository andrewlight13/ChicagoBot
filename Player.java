package projectdicecord;

import java.util.*;

public class Player {
	private int lives;	//add getter/setter/dedicated decrement function
	private ArrayList<Integer> lastRoll;	//maybe make this an ordered list
	private ArrayList<Integer> selected;
	private int rolls;
	
	Player(){
		lastRoll = new ArrayList<Integer>();
		selected = new ArrayList<Integer>();
		lives = 3;
		rolls = 0;
	}
	
	public void rollDice() {			//this will be for (re-)rolling, not sure what we should do for parameters just yet
		Random r = new Random();
		switch  (selected.size()){
			case 0:
				lastRoll.clear();
				lastRoll.add(r.nextInt(6) + 1);
				lastRoll.add(r.nextInt(6) + 1);
				lastRoll.add(r.nextInt(6) + 1);
				rolls++;
				break;
			case 1:
				lastRoll.clear();
				lastRoll.add(r.nextInt(6) + 1);
				lastRoll.add(r.nextInt(6) + 1);
				rolls++;
				break;
			case 2:
				lastRoll.clear();
				lastRoll.add(r.nextInt(6) + 1);
				rolls++;
				break;
			case 3:
				lastRoll.clear();
				rolls++;
				break;
		}
	} 
	public int isSpecial() {				
		//checks current contents of lastRoll & selected, should be run every time you roll, 
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
		
		for(int i: selected)
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
	
	public void selectDie(int num)
	{
		if(lastRoll.contains(num))
		{
			selected.add(num);
			lastRoll.remove(lastRoll.indexOf(num));
		}
		
	}
	
	public void deselectDie(int num)
	{
		lastRoll.add(num);
		selected.remove(selected.indexOf(num));
	}
	
	public void endRoll()
	{
		if(rolls < 4)
		{
			rollDice();
		}
		else
			endTurn();
	}
	
	public void endTurn()
	{
		selected.clear();
		rolls = 0;
	}
	
	public void printDieVals() {
		System.out.println("Dice from cup: ");
		for(int i: lastRoll)
		{
			if( i != 0)
			System.out.println(i);
		}
		System.out.println("Dice selected: ");
		for(int i: selected)
		{
			if( i != 0)
			System.out.println(i);
		}
	}
}

enum Reroll{		//should probably put this in its own file, but doesn't matter too much lol
					//is kinda useless now i think ???
	OOO, OOI, OIO, OII, IOO, IOI, III
}
