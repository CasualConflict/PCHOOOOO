package edu.id.meteordodge;

import java.io.File;


public class FloatingPeople {
	//FloatingPeople Variables
	private static int MOVE_SPEED = 5;
	private int yCoordinate = (int)(Math.random() * 270 + 450);
	private int xCoordinate = 0;
	private static final int ANGLE = 5;
	private boolean right = false;
	private String prefix = "MeteorDodgePeoplesUpdated" + File.separator;
	private boolean active;
	//Image List
	private String[] filenames = {
			"3AMJade.png", 
			"AceDick.png", 
			"AlphaDave.png", 
			"Aradiabot.png", 
			"AradiaFedora.png", 
			"Aranea.png", 
			"Babyball.png", 
			"Bec.png", 
			"Bucket.png",
			"Cal.png", 
			"Calsprite.png", 
			"CalStitched.png", 
			"ClubsDeuce.png", 
			"CodTierGamzee.png", 
			"CourtyardDroll.png", 
			"Davesprite.png", 
			"DeadAradia.png", 
			"DeadGodTierKarkat.png", 
			"DeadshuffleJade.png", 
			"DiamondsDroog.png", 
			"Dirk.png", 
			"DirkBrobot.png",
			"DirkWifebeater.png",
			"DocScratch.png",
			"DoomedDave.png", 
			"DraconianDignitary.png", 
			"Equius.png", 
			"Eridan.png",
			"EridanCapeless.png",
			"EridanGlasses.png",
			"FairyDressVriska.png",
			"Feferi.png",
			"Gamzee.png",
			"GodTierAradia.png",
			"GodTierDave.png",
			"GodTierHussie.png",
			"GodTierJade.png",
			"GodTierRose.png",
			"GodTierVriska.png",
			"GrimdarkOutfitRose.png",
			"HalfDeadSollux.png",
			"HeartsBoxcars.png",
			"Hussie.png",
			"HussieBot.png",
			"IronJade.gif",
			"JackNoir.png",
			"JadeBot.png",
			"JakeBelt.png",
			"JakeHelmet.png",
			"Jane.png",
			"JaneDisguise.png",
			"Jaspersprite.png",
			"KanayaBlue.png",
			"KanayaGreen.png",
			"KanayaPink.png",
			"KanayaRainbowdrinker.png",
			"KanayaRainbowdrinkerDress.png",
			"Karkat.png",
			"LordEnglish.png",
			"Meenah.png",
			"Nannasprite.png",
			"Nepeta.png",
			"NepetaHatless.png",
			"PickleInspector.png",
			"Problem Sleuth.png",
			"RedDave.png",
			"Roxy.png",
			"RoxyScarf.gif",
			"RPTerezi.png",
			"SkylarkTavros.png",
			"SoberGamzee.png",
			"Sollux.png",
			"SolluxGlassesless.png",
			"SpadesSlick.png",
			"SquiddleknitJade.png",
			"Tavrisprite.png",
			"Terezi.png",
			"TereziGlassesless.png",
			"TrollHussie.png",
			"Unreal Air.png",
			"WheelchairTavros.png"};

	private String picture = filenames[0];
	/**
	 * Constructor
	 * @param people
	 */
	public FloatingPeople(boolean activeO){
		picture = getPicture();
		active = activeO;
		if ((int)(Math.random() + .5) == 1){
			xCoordinate =1690;
			right = true;
		}
		else 
			xCoordinate = -90;
	}
	/**
	 * Gets the picture for the random floating person.
	 * @return
	 */
	public String getPicture(){
		int length = filenames.length - 1;
		int random = (int)(Math.random() * length);
		return filenames[random];
	}
	/**
	 * Moves the person across the screen.
	 */
	public void movePerson(){
		if (active == false)
			MOVE_SPEED = 2;
		if (right == true)
			xCoordinate -= MOVE_SPEED;
		else
			xCoordinate += MOVE_SPEED;
	}
	/**
	 * Draws the person onto the screen.
	 * @param turns
	 */
	public void printPerson(int turns){
		if (picture.equals("Babyball.png"))
			StdDraw.picture(xCoordinate-90, yCoordinate, prefix+picture, 180, 180, (turns * ANGLE));
		else
			StdDraw.picture(xCoordinate, yCoordinate, prefix+picture, 90, 90, (turns * ANGLE));
	}
	/**
	 * Performs all operations on the person.
	 * @param turns
	 */
	public void runPeople(int turns, boolean iP){
		if (iP==false){
			movePerson();
			printPerson(turns);
		}
	}
}