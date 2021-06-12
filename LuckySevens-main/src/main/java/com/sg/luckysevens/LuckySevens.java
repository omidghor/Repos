/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author agill
 */
public class LuckySevens {
    public static void main(String[] args) {
        int money = 0;
        int maxMoney = 0;
        int rolls = 0;
        int diceTotal = 0;
        int maxMoneyRoll = 0;
        Scanner input = new Scanner(System.in);
        
        
        //ask user how many dollars
        System.out.println("How much money do you have to bet? ");
        money = input.nextInt();
        maxMoney = money; 
        
        
        while( money > 0){
        diceTotal = GetDiceRoll() + GetDiceRoll();
        
        if(diceTotal == 7)
        {
            money += 4;
            //track which roll had most money
            //track max money
            if( money > maxMoney)
            {
                maxMoney = money;
                maxMoneyRoll = rolls;
            }
        }
        else
        {
            money -= 1;
        }
         //track how many rolls
        rolls++;
            System.out.println("Roll #" + rolls +"\tMoney: " + money + "\tdice total: " + diceTotal);
    }
        
        // print out results
        System.out.println("You are broke after " + rolls + " rolls.");
        System.out.println("You should have quit after " + maxMoneyRoll + " rolls when you had $" + maxMoney);
        
       
        
         //roll dice till they have zero dollars
        
        
        
       
        
        
        
        
    }
    
    public static int GetDiceRoll()
    {
        Random rng = new Random();
        return rng.nextInt(6) + 1;
    }
}
