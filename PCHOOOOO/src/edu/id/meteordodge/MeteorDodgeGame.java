package edu.id.meteordodge;

import java.awt.Color;

public class MeteorDodgeGame {
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		int selection = 0;
		StartMenu.printMenu();
		while (selection == 0){
			if (selection == 0)
				selection = StartMenu.clickCheck();
			if (selection == 1){
				StdDraw.clear(Color.BLACK);
				game.playSong();
				game.reset();
				game.runTimers();
				game.playGame();
			}
			else if (selection == 2){
				InstructionsMenu.printMenu();
			}
			while (selection == 2){
				selection = InstructionsMenu.clickCheck();
			}
			if (selection == 3){
				StartMenu.printMenu();
				selection = 0;
			}
		}
	}
}