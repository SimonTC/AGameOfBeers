package dk.itu.KF13.TheSim.Game.Controller;

import java.util.Scanner;

import dk.itu.KF13.TheSim.Game.Model.GameRunner;
import dk.itu.KF13.TheSim.Game.Model.Physical.Class.HumanPlayer;
import dk.itu.KF13.TheSim.Game.Model.World.Interface.Location.Direction;
import dk.itu.KF13.TheSim.Game.View.GameView;

/**
 * GameController parses user input and calls the corresponding methods from the model
 * @author Simon & Thelle
 *
 */
public class GameController implements IGameController {
	
	private GameRunner runner;
	private HumanPlayer player;
	
	public void setGameRunner(GameRunner gameRunner){
		this.runner = gameRunner;		
	}
	
	public void setPlayer (HumanPlayer player){
		this.player = player;
	}
	
	/**
	 * Takes written user input and runs the method according to command.
	 * @return true if the player doesn't choose to stop the game
	 * @return false if the player chooses to stop the game
	 */
	public boolean getCommand(){
		GameView.print("What do you want to do?");
		String input = getStringInput();
		input = input.toLowerCase();
		
		if (input.matches("go [a-z]*")){
			testMovement(input);
			return true;
		}
		else if (input.matches("take .*")){
			player.takeObject(input);
			return true;
		} 
		else if (input.matches("use .*")){
			player.useObject(input);
			return true;
		} 
		else if (input.matches("exit game")){
			return false;
		} 
		else if(input.matches("look in backpack")){
			player.lookInBackpack();
			return true;
		}
		else if(input.matches("play blackjack")){
			runner.blackjackConditionsCheck();
			return true;
		}
		else if(input.matches("help")){
			this.printHelpText();
			return true;
		}
		else {
			GameView.print("I did not understand the input.");
			return true;
		}
	}	
	
	/**
	 * testMovement parse the user input and calls the movePlayer method 
	 * to move the player in the correct direction
	 * @param input - the written user input
	 */
	private void testMovement(String input){
		switch (input){
		case "go north": runner.movePlayer(Direction.NORTH);break;
		case "go south": runner.movePlayer(Direction.SOUTH);break;
		case "go west": runner.movePlayer(Direction.WEST);break;
		case "go east": runner.movePlayer(Direction.EAST);break;
		default:GameView.print("I did not understand the direction.");break;
		}
	}
	
	/**
	 * Reads input from the scanner and returns it
	 */
	public String getStringInput(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}
	
	public void printHelpText(){
		String output ="'take [something]' - You take the object specified inside the []. \n" +
				"'use [something]'  - You use the object specified inside the []. You have to have the object in your backpack. \n"+
				"'go [north/east/south/west]' - You move in the given direction. \n"+
				"'look in backpack' - You take a look in your backpack. \n"+
				"'help' - This text will appear again.";
		
		GameView.printnl(output);
	}
	
}
