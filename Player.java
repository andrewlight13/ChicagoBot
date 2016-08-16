package projectdicecord;

import java.util.*;

public class Player {
    private int lives;  //add getter/setter/dedicated decrement function
    private ArrayList<Integer> lastRoll;    //maybe make this an ordered list
    private ArrayList<Integer> selected;
    private int rolls;
    public int score;
    
    Player(){
        lastRoll = new ArrayList<Integer>();
        selected = new ArrayList<Integer>();
        lives = 3;
        rolls = 0;
        score = 0;
    }
    
    public void rollDice() {            //this will be for (re-)rolling, not sure what we should do for parameters just yet
        Random r = new Random();    //random value of "5" for double 6 testing
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
            default:
                System.out.println("rolling no dice, you shouldn't be able to reach this");
                break;
        }
    }
    public void cheat(){    //temporary cheater method, makes testing WAY easier
        lastRoll.clear();
        selected.clear();
        lastRoll.add(6);
        lastRoll.add(6);
        selected.add(6);
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
        
        return 0;   //NO ONE IS SPECIAL (implement this lol)
    }
    public boolean multiSix(int assign){
        int counter = 0;
        //System.out.print("multisix called: ");
        if((isSpecial() == 2 || isSpecial() == 1) && assign == 2){  //assign = 2 -> pull 2 dice
            //System.out.print("entered main if");
            while(counter < 2){
                if(lastRoll.indexOf(6) == -1){
                    selected.remove(selected.indexOf(6));
                    counter++;
                }
                else{
                    lastRoll.remove(lastRoll.indexOf(6));
                    counter++;
                }
            }
            selected.add(1);
            printDieVals();
            return true;
        }
        else if(isSpecial() == 2 && assign == 3){   //assign = 3 -> pull 3 dice
            //System.out.print("entered main if");
            while(counter < 3){
                if(lastRoll.indexOf(6) == -1){
                    selected.remove(selected.indexOf(6));
                    counter++;
                }
                else{
                    lastRoll.remove(lastRoll.indexOf(6));
                    counter++;
                }
            }
            selected.add(1);
            selected.add(1);
            printDieVals();
            return true;
        }
        return false;
    }
    public int getScore(boolean isHigh) 
    {   //get round score
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
            for(int i: selected)
            {
                if(i == 1) sum += 100;
                else if(i == 6) sum += 60;
                else sum += i;
            }
            score = sum;
            return sum;
        }
        else
        {
            for(int i: lastRoll)
                sum += i;
            for(int i: selected)
                sum += i;
            score = sum;
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
    
    public void endRoll(boolean isHigh)
    {
        if(rolls < 4)
        {
            rollDice();
        }
        else
            endTurn(isHigh);
    }
    
    public void endTurn(boolean isHigh)
    {
        getScore(isHigh);
        selected.clear();
        rolls = 0;
    }
    
    public void printDieVals() {
        if(!lastRoll.isEmpty()) System.out.println("Dice from cup: ");
        for(int i: lastRoll)
        {
            System.out.println(i);
        }
        if(!selected.isEmpty()) System.out.println("Dice selected: ");
        for(int i: selected)
        {
            System.out.println(i);
        }
    }
}
