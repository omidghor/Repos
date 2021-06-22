/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omidghor.rockpaperscissors;

/**
 *
 * @author omidghor
 */
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ryanmohar
 */
public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Random rGen = new Random();

        int player1;
        int cpu;
        int rounds;
        int cpuScore = 0;
        int round = 0;
        int player1Score = 0;
        int ties = 0;
        String answer = "";

        do {
            System.out.println("Rock Paper Scissors!!!!!");
            System.out.println("How many rounds would you like to play? min 1 round max 10 rounds");
            rounds = userInput.nextInt();
            round = 0;
            while (round < rounds) {
                // game ends when cpuScore or player1Score is gretaer than the set rounds 

                if (rounds > 10 || rounds < 0) {
                    System.out.println("error: invaild choice please refresh to start over ");
                    System.exit(0);
                    // displays error if choice is outside of parameters
                }
                do{
                    System.out.println("make a choice using numbers 0 = rock, 1 = paper, 2 = scissors");
                player1 = userInput.nextInt();
                userInput.nextLine();

                
                
                
                if  (player1 < 0 || player1 > 2)  
                System.out.println("error invaid choice");
                }while (player1 < 0 || player1 > 2) ;
                    // displays error if choice is outside of parameters
                
                

                cpu = rGen.nextInt(3);
                // set cpu to random with the highest number being 2 

                if (player1 == cpu) {
                    ties++;
                    round++;
                    // increments tie score
                    System.out.println(" Tie Game! " + " player1 score: " + player1Score + " cpu score: " + cpuScore + " Ties: " + ties);

                } else if ((player1 == 0 && cpu == 2) || (player1 == 2 && cpu == 1) || (player1 == 1 && cpu == 0)) {
                    player1Score++;
                    round++;
                    // increments  player1Score
                    System.out.println(" Player1 Wins! " + " -- player1 score:  " + player1Score + " -- cpu score:  " + cpuScore + " -- Ties:  " + ties);

                } else {
                    cpuScore++;
                    round++;
                    // increments cpuScore
                    System.out.println(" Cpu  Wins! " + " -- player1 score:  " + player1Score + " -- cpu score:  " + cpuScore + " -- Ties:  " + ties);

                }

            }

            if (round == rounds) {
                System.out.println("thank you for playing want to play again?:: type in yes or no");
                answer = userInput.nextLine();
                
            }

        } while (answer.equals("yes"));
    }
}
