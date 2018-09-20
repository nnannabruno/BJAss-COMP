package core;

import java.io.FileNotFoundException;
import java.util.*;


public class BlackJack {

public static void main(String[] args) throws FileNotFoundException{
		
		System.out.println("Welcome to Blackjack!");
		ConsoleGame console = new ConsoleGame();
		FileGame file = new FileGame();
		//select file or console
		int response = choiceInput();
		//console
		if(response == 1){
			console.consoleGame();
		}
		
		//file
		if(response == 2){
			file.fileGame();
		}
	
				
}
 public static int choiceInput() {
	  Scanner userInput = new Scanner(System.in);
	  System.out.println("Would you like to play using(1)Console or (2)Files");
	  int response = userInput.nextInt();
	  //close Scanner
	  //userInput.close();	
	  return response;
	 
 }
 
}
