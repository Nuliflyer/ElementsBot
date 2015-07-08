import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

// -1 = setup
// 0 = menu
// 1 = your turn
// 2 = their turn
// 3 = defeat
// 4 = victory

public class ElementsBot {
	public static void main(String args[]) throws AWTException, InterruptedException{
		Robot r = new Robot();
		int gS = 0;
		int count = 0;
		 
		while(true){
		switch(gS){
		case 0 :  
			System.out.println("Main Menu");
			r.mouseMove(950, 360); 
			Thread.sleep(100);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			gS = 1;
			break;
			
		case 1 : 
			System.out.println("My Turn");
			for(int index2 = 0; index2 < 2; index2++){
				Thread.sleep(100);
			for(int index = 0; index < 8; index++){
				r.mouseMove(1200, 650 - index*24);
				if(r.getPixelColor(1240, 650 - index*24).getRed() > 80){
					r.mousePress(InputEvent.BUTTON1_MASK);
					Thread.sleep(50);
			r.mouseRelease(InputEvent.BUTTON1_MASK);	
				}
			}
			}
			r.keyPress(32);
			gS = 2;
			break;
			
		case 2 :
			System.out.println("Their Turn");
			while(true){
				r.mouseMove(1200,  650);
				Thread.sleep(100);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				Thread.sleep(1000);
				if(r.getPixelColor(470, 220).getRed() == 196){
				gS = 1;
				break;
				}
				if(r.getPixelColor(800, 474).getRed() == 116){
				gS = 3;
				break;
				}
				if(r.getPixelColor(800, 474).getRed() == 175){
				gS = 4;
				break;
				}
			}
			break;
			
		case 3 :
			System.out.println("Defeat");
			r.mouseMove(800,  530);
			Thread.sleep(100);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			gS = 0;
			break;
			
		case 4 :
			System.out.println("Victory");
			r.mouseMove(830, 560);
			Thread.sleep(100);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep(8500);
			r.mouseMove(780, 690);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			gS = 0;
			break;
			}
		}
	}
}
