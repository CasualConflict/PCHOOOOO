package edu.id.meteordodge;

public class Meteor {
	//Meteor Variables
	private int xCoordinate = (int) (Math.random()*1600 + 40);
	private int yCoordinate = 1100;
	private int FALL_RATE = 20;

	/**
	 * Constructor
	 */
	public Meteor(){
	}

	/**
	 * Returns the X-Coordinate.
	 * @return
	 */
	public int getX(){
		return xCoordinate;
	}
	
	/**
	 * Returns the Y-Coordinate
	 * @return
	 */
	public int getY(){
		return yCoordinate;
	}
	
	/**
	 * Moves the Y-Coordinate down.
	 */
	public void move(){
		yCoordinate -= FALL_RATE;
	}
	
	/**
	 * Checks for overlaps between the player and a meteor.
	 * @param player
	 * @return
	 */
	public boolean checkCollision(Player player){
		boolean overlap = false;
		int left = xCoordinate - 75;
		int right = xCoordinate + 75;
		int top = yCoordinate + 75;
		int bottom = yCoordinate - 75;
		int playerLeft = player.getX() - 52;
		int playerRight = player.getX() + 52;
		int playerTop = player.getY() + 65;
		int playerBottom = player.getY() - 65;
		if ((playerRight>left) && (playerLeft<right))
			if ((playerBottom<top) && (playerTop>bottom))
				overlap = true;
		return overlap;
	}
}
