package edu.id.meteordodge;

public class Smoke {
	private int xCoordinate;
	private int yCoordinate = 50;
	public Smoke(Player x){
		xCoordinate = x.getX();
	}
	
	public void moveSmoke(){
		yCoordinate-=9;
	}
	public void printSmoke(){
		StdDraw.picture(xCoordinate, yCoordinate, "Smoke Cloud.png", 50, 65);
	}
	public int getY(){
		return yCoordinate+50;
	}
	public void runSmoke(){
		moveSmoke();
		printSmoke();
	}
}
