package spring.start;

import spring.impls.sony.SonyHand;
import spring.impls.sony.SonyHead;
import spring.impls.toshiba.ToshibaLeg;


public class RobotConstructor {
	
	public static void main(String[] args){
		
		SonyHand sonyHand = new SonyHand();		
		ToshibaLeg toshibaLeg = new ToshibaLeg();		
		SonyHead sonyHead = new SonyHead();
		
		Robot robot = new Robot(sonyHand, toshibaLeg, sonyHead);
		
		robot.action();
		
		
	}

}
