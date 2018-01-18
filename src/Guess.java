/**
*  author: Bryan Vuong
*  date:  10/27/2010
*  CS 305j Assignment 6
*  On my honor, Bryan Vuong, this programming assignment is my own work.
*
*  EID: BKV85
*  Section: 52263, T 3-4
*
* The program generates a random number from 1 to a specified number. The user then 
* plays a game to guess what that number is
*
* Slip Days I am using on this project: 2
* Slip Days I have used this semester: 0
*/
import java.util.*;
public class Guess {
//Set the range of the number. 1 to MAX
public static final int MAX = 100;
public static void main (String[] args)
{
	prompt();
	//Initialize values for the sum (# of games played), totalguesses (the total
	//amount of guesses made), and trial (# of guesses in game)
	int sum = 0;
	//Call first round of game
	int totalguesses = game();
	int trial = 0;
	//maxGuesses initializes the total amount of guesses from round 1
	int maxGuesses = totalguesses;
	//first round played, so total rounds gets incremented
	sum++;
	//Create Scanner object
	Scanner console = new Scanner(System.in);
	//Prompt user to play again
	System.out.print("Do you want to play again?");
	String s = console.next();
	//if the entered input begins with a y, program enters while loop, otherwise, prints
	//statistics
	while(s.charAt(0) == 'y' || s.charAt(0) == 'Y')
	{
	//Call game again
	trial += game();
	//Add on amount of guesses
	totalguesses += trial;
	//Determine which round had the maximum # of guesses
	maxGuesses = Math.max(maxGuesses, trial);
	//increment rounds
	sum++;
	//Prompt user to play again
	System.out.print("Do you want to play again?");
	s = console.next();
	}
	//If the input doesn't begin with a y, the game exits/skips the while loop and 
	//prints the results
	statistics(sum, totalguesses, maxGuesses);
}
//Generates the random number of the computer
public static int computer()
{
	Random generator = new Random();
	int ran = generator.nextInt(MAX)+1;
	return ran;
}
//Introductory prompt with game's instructions
public static void prompt()
{
	System.out.println("This program allows you to play a guessing game.");
	System.out.println("I will think of a number between 1 and " + MAX);
	System.out.println("and will allow you to guess until you get it.");
	System.out.println("For each guess, I will tell you whether the");
	System.out.println("right answer is higher or lower than your guess.");
}
//Game method while taking user input
public static int game()
{
	int comp = computer();
	int tries = 0;
	System.out.println("I'm thinking of a number...");
	Scanner scan = new Scanner(System.in);
	System.out.print("Your guess? ");
	int guess = scan.nextInt();
	//Remains in the while loop if the user's guess doesn't match the computer's number
	while(guess != comp)
		{
			//If the guess is larger than the random #, a clue to go lower is given
			if(guess > comp)
			{
				System.out.println("lower");
				tries++;
				System.out.print("Your guess? ");
				guess = scan.nextInt();
			}
			//If the guess isn't large nor equals to the guess must be lower than the 
			//random # generated
			else
			{
				System.out.println("higher");
				tries++;
				System.out.print("Your guess? ");
				guess = scan.nextInt();
			}
		}
	tries++;
	System.out.println("You got it right in " + tries + " guesses.");
	return tries;
}
//Print game's statistics
public static void statistics(int games, int guesses, int maxGuesses)
{
	System.out.println("Overall Results:");
	System.out.println("total games = " + games);
	System.out.println("total guesses = " + guesses);
	double gPerG = guesses/games;
	System.out.println("guesses/game = " + gPerG);
	System.out.println("max guesses = " + maxGuesses);
}
}
