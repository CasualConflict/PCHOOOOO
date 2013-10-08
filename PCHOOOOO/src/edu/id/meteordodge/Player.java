package edu.id.meteordodge;

import java.awt.event.KeyEvent;

public class Player {
	//Player Variables
	private static final int Y_COORDINATE = 130;
	private static int xCoordinate = 500;
	private final int MOVE_RATE = 20;

	/**
	 * Constructor
	 */
	public void player(){
	}

	public boolean godTier(boolean available){
		if (available == true){
			if(StdDraw.isKeyPressed(KeyEvent.VK_8)){
				return true;
			}
		}
		return false;
	}
	public boolean fire(){
		if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
			return true;
		}
		return false;
	}
	
	/**
	 * Moves the player based on keyboard input.
	 * @return
	 */
	public int movePlayer(){
		int tiltyThing = 0;
		if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
			xCoordinate -= MOVE_RATE;
			tiltyThing = 1;
			return tiltyThing;
		}

		if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
			xCoordinate += MOVE_RATE;
			tiltyThing = 2;
			return tiltyThing;
		}
		else
			return tiltyThing;
	}

	/**
	 * Returns the X-Coordinate.
	 * @return
	 */
	public int getX() {
		return xCoordinate;
	}

	/**
	 * Returns the Y-Coordinate.
	 * @return
	 */
	public int getY() {
		return Y_COORDINATE;
	}

	/**
	 * Adjusts the X-Coordinates to keep John inbounds.
	 */
	public void checkBounds(){
		int left = xCoordinate - 160;
		int right = xCoordinate + 160;
		if (left<-185)
			xCoordinate = -25;
		if (right>1785)
			xCoordinate = 1625;
	}
}
