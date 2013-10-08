package edu.id.meteordodge;

public class GodBullets {
	private int xCoordinate;
	private int yCoordinate = 190;
	private int ASCEND_RATE = 30;
	
	public GodBullets(Player x){
		xCoordinate = x.getX();
	}
	public void moveBullet(){
		yCoordinate += ASCEND_RATE;
	}
	public void printBullet(){
		StdDraw.picture(xCoordinate, yCoordinate, "Windy Thing.png", 50, 100);
	}
	public int getY(){
		return yCoordinate;
	}
	public boolean checkCollision(Meteor meteor){
		boolean overlap = false;
		int left = xCoordinate - 25;
		int right = xCoordinate + 25;
		int top = yCoordinate + 50;
		int bottom = yCoordinate - 50;
		int meteorLeft = meteor.getX() - 80;
		int meteorRight = meteor.getX() + 80;
		int meteorTop = meteor.getY() + 80;
		int meteorBottom = meteor.getY() - 80;
		if ((meteorRight>left) && (meteorLeft<right))
			if ((meteorBottom<top) && (meteorTop>bottom))
				overlap = true;
		return overlap;
	}
}