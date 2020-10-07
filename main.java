package auto;

import java.util.Scanner;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileNotFoundException;

public class main {
	public static int clicks = 10;
	public static int seconds = 3;
	
	public static void main(String[]args) {

		seconds = seconds * 1000;
		run();
	}
	
	private static void run() {
		try {
			// Fields
			Robot bot = new Robot();
			
			// Process
			//getVariables();
			process(bot);
			System.out.println("Exiting...");
			
		} catch (AWTException e) {
			System.out.println("Error.");
		}  		
	}
	private static void process(Robot bot) {
		try {			
			System.out.println("Seconds: "+(seconds/1000)+"\nClicks : "+clicks+"\nProcessing...\n");
			Thread.sleep(seconds);
			for(int x = 1; x <= clicks; x++) {
				System.out.println("Click Number: " +(x)+ "/" +clicks);
				bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(100);
				bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(seconds);
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// Attempt to make standalone application
	public static void getVariables() {
	    try {
	      File myObj = new File("D:\\Users\\Ryan\\eclipse-workspace\\auto\\settings.txt");
	      Scanner scan = new Scanner(myObj);
	        
	      String tempString = scan.nextLine();
	      	tempString = tempString.substring(tempString.indexOf(":") +1);
	      	tempString = tempString.trim();					// remove whitespace
	      	seconds = Integer.parseInt(tempString) *1000; 	// time 1000 because miliseconds
	      	
	      tempString = scan.nextLine();
	      	tempString = tempString.substring(tempString.indexOf(":") +1);
	      	tempString = tempString.trim();					// remove whitespace
	      	clicks = Integer.parseInt(tempString);
	
	      scan.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("Cant find file: Settings.txt");
	      e.printStackTrace();
	    }
	  }
}