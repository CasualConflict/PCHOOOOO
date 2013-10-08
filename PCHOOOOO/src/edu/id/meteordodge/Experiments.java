package edu.id.meteordodge;


import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Experiments {

	//Global Variables
	private static ArrayList<Meteor> meteors = new ArrayList<Meteor>();
	private static ArrayList<FloatingPeople> people = new ArrayList<FloatingPeople>();
	private static ArrayList<Smoke> smoke = new ArrayList<Smoke>();
	private static Player john = new Player();
	private Timer randomTimer = new Timer(); 
	private static int tiltyThing = 0;
	private static int timer = 100;
	private int turns = 0;
	private boolean initialPerson = true;
	private int score = 0;
	private String scoreText = "";
	private int lives = 2;
	private String livesText = "2";
	private boolean playerActive = true;
	private boolean smokeA = true;
	/**
	 * Constructor
	 */
	public Experiments(){
	}


	/**
	 * Runs the actual Game.
	 */
	public void playGame(){
		


		
		Font font = new Font("Sans Serif", Font.BOLD, 65);
		StdDraw.setCanvasSize(1600, 900);
		StdDraw.setXscale(0,1600);
		StdDraw.setYscale(0,900);
		StdDraw.setFont(font);
		people.add(new FloatingPeople(playerActive));
		smoke.add(new Smoke(john));
		//Smoke Timer
		randomTimer.schedule(new TimerTask(){
			public void run() {
				smoke.add(new Smoke(john));
				smokeA = true;
			}
		}, 0, 175);
		//RandomPerson Timer
		randomTimer.scheduleAtFixedRate(new TimerTask(){
			public void run() {
				people.remove(0);
				people.add(new FloatingPeople(playerActive));
				initialPerson = false;
			}
		}, 5000, 30000);
		//Score Timer
		randomTimer.scheduleAtFixedRate(new TimerTask(){
			public void run() {
				score ++;
				if (playerActive == true)
					scoreText = "" + score;
			}
		}, 1000, 1000);
		//Sound.
		StdAudio.loop("UniteSynchronization.wav");
		while (true) {
			//Meteor spawn timer.
			if (timer>=30){
				meteors.add(new Meteor());
				timer = 0;
			}
			//Move/tilt john.
			tiltyThing = john.movePlayer();
			john.checkBounds();

			//Print background/ random floating people.
			StdDraw.clear();
			StdDraw.picture(800,450, "LOWAS.png", 1800, 1100);
			people.get(0).runPeople(turns, initialPerson);
			turns ++;

			//Activates meteor/player spawns/movements while John is alive.
			if (checkMeteors(john) == false) {
				lives--;
				livesText = "" + (lives);
				if (lives == 0)
					livesText = "Last life!";
				if (lives == -1)
					livesText = "None. GAME OVER.";
			}
			if ((lives>=0) && (playerActive == true)){
				if (tiltyThing == 0){
					StdDraw.picture(john.getX(), john.getY(), "player.png", 105, 130);
				}
				else if (tiltyThing == 1)
					StdDraw.picture(john.getX(), john.getY(), "player.png", 105, 130, 10);
				else if (tiltyThing == 2)
					StdDraw.picture(john.getX(), john.getY(), "player.png", 105, 130, -10);
				checkOutOfBounds();
				//Smoke Deleter
				for (int i =0; i<smoke.size(); i++){
					if (smokeA == true){
						smokeCheck(i, smoke);
						smokeA = false;
					}
					smoke.get(i).runSmoke();
				}
				moveMeteors();
				printMeteors();
				displayScore();
				displayLives();
				StdDraw.show(38);
				timer += (int) (Math.random() * 10);
			}
			//Cuts off all movement when John dies.
			else{
				playerActive = false;
				StdDraw.clear();
				StdDraw.picture(800,450, "LOWAS.png", 1800, 1100);
				printMeteors();
				displayScore();
				displayLives();
				StdDraw.show(1);
			}
		}
	}



	/**
	 * Moves all meteors in list meteors down by FALL_RATE.
	 */
	public void moveMeteors(){
		for (int i = 0; i<meteors.size(); i++){
			meteors.get(i).move();
		}
	}

	/**
	 * Prints all meteors in list meteors.
	 */
	public void printMeteors(){
		for (int i = 0; i<meteors.size(); i++){
			StdDraw.picture(meteors.get(i).getX(), meteors.get(i).getY(), "meteor.png", 160, 160);
		}
	}

	/**
	 * Checks all meteors in list meteors for collision with player.
	 * @param john
	 * @return
	 */
	public boolean checkMeteors(Player john){
		for (int i = 0; i<meteors.size(); i++){
			if (meteors.get(i).checkCollision(john) == true){
				meteors.remove(i);
				return false;
			}
		}
		return true;
	}

	/**
	 * Deletes off-screen meteors.
	 */
	public void checkOutOfBounds(){
		for(int i = 0; i<meteors.size(); i ++){
			if (meteors.get(i).getY()+80 < 0){
				meteors.remove(i);
			}
		}
	}

	/**
	 * Prints Score.
	 */
	public void displayScore(){
		StdDraw.textRight(1575, 860, ("Score: " + scoreText));
	}
	public void displayLives(){
		StdDraw.textLeft(-20, 860, ("Lives: " + livesText));
	}
	public void smokeCheck(int i, ArrayList<Smoke> smoke){
		if (smoke.get(i).getY() < 90)
			smoke.remove(i);
	}
		
		public static void main(String[] args) {
			Experiments game = new Experiments();
			game.playGame();
		}

}
